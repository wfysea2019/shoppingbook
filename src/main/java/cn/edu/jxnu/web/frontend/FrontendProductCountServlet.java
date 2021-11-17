package cn.edu.jxnu.web.frontend;

import cn.edu.jxnu.service.ProductService;
import cn.edu.jxnu.service.impl.ImplProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontendProductCountServlet", value = "/frontend/prodCount.do")
public class FrontendProductCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookName=request.getParameter("bookName");
        System.out.println("bookName数据,"+bookName);
        Map<String,Object> model =new HashMap<String,Object>();
        ProductService productService=new ImplProductService();
        int prodCnt=0;
        try {
            prodCnt=productService.countProductsNumber(bookName);
            model.put("success",true);
            model.put("recordCount",prodCnt);

        } catch (Exception e) {
            e.printStackTrace();
            model.put("success",false);
            model.put("errMsg",e.getMessage());
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(model));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
