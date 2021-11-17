package cn.edu.jxnu.web.frontend;

import cn.edu.jxnu.domain.ProductDomain;
import cn.edu.jxnu.service.ProductService;
import cn.edu.jxnu.service.ProductTypeService;
import cn.edu.jxnu.service.impl.ImplProductService;
import cn.edu.jxnu.service.impl.ImplProductTypeService;
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

@WebServlet(name = "NewProductServlet", value = "/frontend/newbook.do")
public class NewProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,Object> model=new HashMap<String,Object>();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();

        ProductService productService=new ImplProductService();
        ProductTypeService productTypeService=new ImplProductTypeService();

        //新书上架
        List<ProductDomain> newItemList =null;


        try {

            newItemList= productService.queryProductOrderID(0,12,"");


            model.put("success",true);
            model.put("newItemList",newItemList);

        } catch (Exception e) {
            e.printStackTrace();
            model.put("success",false);
        }
        ObjectMapper objectMapper=new ObjectMapper();
        out.println(objectMapper.writeValueAsString(model));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
