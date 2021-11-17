package cn.edu.jxnu.web.user;

import cn.edu.jxnu.domain.UserDomain;
import cn.edu.jxnu.service.UserService;
import cn.edu.jxnu.service.impl.ImplUserService;
import cn.edu.jxnu.util.CodeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/user/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        String username = request.getParameter("userName");
        String pwd = request.getParameter("password");


        //调用业务处理层
        UserService userService = new ImplUserService();
        UserDomain userDomain = null;

        //验证码校验
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            out.println(new ObjectMapper().writeValueAsString(modelMap));
            return;
        }
        // 非空校验
        if (username == null || username.trim().equals("") || pwd == null || pwd.trim().equals("")) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名和密码均不能为空");
            out.println(new ObjectMapper().writeValueAsString(modelMap));
            return;
        }

        try {
            userDomain = userService.findUser(username, pwd);

            //用户名密码正确
            if (userDomain != null) {

                //增加判断state的逻辑
                if (userDomain.getState()==0){
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "该用户还未激活，请前往邮箱进行激活！");
                }else{
                    modelMap.put("success", true);
                    request.getSession().setAttribute("user", userDomain);
                }

            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "用户名或密码错误");
            }

        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", "内部错误");
        }
        out.println(new ObjectMapper().writeValueAsString(modelMap));
    }
}
