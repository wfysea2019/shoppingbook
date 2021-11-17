package cn.edu.jxnu.web.frontend;

import cn.edu.jxnu.domain.ProductDomain;
import cn.edu.jxnu.service.ProductService;
import cn.edu.jxnu.service.impl.ImplProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FrontendRecomServlet", value = "/frontend/recomproduct.do")
public class FrontendRecomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<String, Object>();
        //获取当前页
        String strPageIndex=request.getParameter("pageIndex");
        //获取每页大小
        String strPageSize=request.getParameter("pageSize");

        String bookName=request.getParameter("bookName");

        System.out.println("bookName"+","+bookName);

        int pageIndex;
        int pageSize;
        try{
            pageIndex=Integer.parseInt(strPageIndex);
        }catch (NumberFormatException e){
            pageIndex=1;
        }

        try{
            pageSize=Integer.parseInt(strPageSize);
        }catch (NumberFormatException e){
            pageSize=4;
        }

        int rowIndex=(pageIndex-1)*pageSize;
        ProductService productService=new ImplProductService();
        List<ProductDomain> productDomainList=null;
        try {
            productDomainList=productService.queryProductOrderID(rowIndex,pageSize,bookName);
            model.put("success", true);
            model.put("productList", productDomainList);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("success", false);
        }

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out=response.getWriter();

        ObjectMapper objectMapper=new ObjectMapper();
        out.println(objectMapper.writeValueAsString(model));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
