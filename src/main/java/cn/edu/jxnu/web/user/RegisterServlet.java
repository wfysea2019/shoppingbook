package cn.edu.jxnu.web.user;

import cn.edu.jxnu.domain.UserDomain;
import cn.edu.jxnu.service.UserService;
import cn.edu.jxnu.service.impl.ImplUserService;
import cn.edu.jxnu.util.CodeUtil;
import cn.edu.jxnu.util.MailEx;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.mail.EmailException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", value = "/user/reg.do")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String password = request.getParameter("pwd");
        String email = request.getParameter("email");
        Date date = new Date();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Map<String, Object> model = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        //验证码校验
        if (!CodeUtil.checkVerifyCode(request)) {
            model.put("success", false);
            model.put("errMsg", "验证码错误");
            out.println(objectMapper.writeValueAsString(model));
            return;
        }
        if (userName == null || userName.trim().equals("") ||
                email == null || email.trim().equals("") ||
                password == null || password.trim().equals("")) {
            model.put("success", false);
            model.put("errMsg", "用户名,密码，邮箱不能为空");
            out.println(objectMapper.writeValueAsString(model));
            return;
        }


        //查找该用户名是否已经被注册
        UserService userService = new ImplUserService();
        try {
            UserDomain u = userService.findUser(userName);
            if (u != null) {
                model.put("success", false);
                model.put("errMsg", "该用户名已经被注册");
                out.println(objectMapper.writeValueAsString(model));
                return;
            }

            //使用uuid生成随机校验码
            String rID = UUID.randomUUID().toString();// 随机生成的验证码,也要存入数据库中
            UserDomain user = new UserDomain();
            user.setCustPwd(password);
            user.setLastLogin(date);
            user.setCustNo(userName);
            user.setEmail(email);
            user.setRandomNum(rID);

            int cnt = userService.insertUser(user);

            // 增加 发一封激活用户的邮件给注册用户

            MailEx.sendRegMail(request,email, rID);
           model.put("success", true);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            model.put("success", false);
            model.put("errMsg", "该用户注册失败");
        } catch (EmailException e) {
            e.printStackTrace();
            model.put("success", false);
            model.put("errMsg", "发送邮件失败");
        }
        out.println(objectMapper.writeValueAsString(model));
    }
}
