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

@WebServlet(name = "ActiveServlet", value = "/user/active.do")
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String ,Object> model=new HashMap<String ,Object>();

        //获取用户随机码
        String randomID=request.getParameter("randomID");
        // 实例化
        UserService userService=new ImplUserService();

        //
        UserDomain userDomain=null;


        int cnt=0;
        try {
            cnt=userService.updateUserState(randomID);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (cnt==1){
            model.put("success",true);
        }else{
            model.put("success",false);
        }

        out.println(objectMapper.writeValueAsString(model));

    }
}
