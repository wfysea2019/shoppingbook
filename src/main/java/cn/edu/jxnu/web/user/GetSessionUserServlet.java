package cn.edu.jxnu.web.user;

import cn.edu.jxnu.domain.UserDomain;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GetSessionUserServlet", value = "/user/getloginuser.do")
public class GetSessionUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        UserDomain user=(UserDomain) session.getAttribute("user");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (user!=null) {
            user.setCustPwd("");
            modelMap.put("success", true);
            modelMap.put("user", user);
        }else
        {
            modelMap.put("success", false);
        }
        out.println(new ObjectMapper().writeValueAsString(modelMap));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
