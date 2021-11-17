package cn.edu.jxnu.web.frontend;

import cn.edu.jxnu.domain.HeaderDomain;
import cn.edu.jxnu.service.HeaderService;
import cn.edu.jxnu.service.impl.ImplHeaderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "HeaderImgServlet", value = "/frontend/header.do")
public class HeaderImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,Object> model=new HashMap<String,Object>();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        HeaderService headerService=new ImplHeaderService();
        List<HeaderDomain> headerDomains=headerService.getHeader();

        model.put("success",true);
        model.put("headList",headerDomains);

        ObjectMapper objectMapper=new ObjectMapper();
        out.println(objectMapper.writeValueAsString(model));
    }
}
