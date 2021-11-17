package cn.edu.jxnu.web.user;

import cn.edu.jxnu.domain.UserDomain;
import cn.edu.jxnu.service.UserService;
import cn.edu.jxnu.service.impl.ImplUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CheckUserIsExistServlet", value = "/user/userexist.do")
public class CheckUserIsExistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name=request.getParameter("name");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Map<String, Object> model = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        //调用业务处理层
        UserService userService = new ImplUserService();

        UserDomain u = null;
        try {
            u = userService.findUser(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (u != null) {
            model.put("success", false);
            model.put("errMsg", "该用户名已经被注册");
            out.println(objectMapper.writeValueAsString(model));

        }else{
            model.put("success", true);
            out.println(objectMapper.writeValueAsString(model));
        }
    }
}
