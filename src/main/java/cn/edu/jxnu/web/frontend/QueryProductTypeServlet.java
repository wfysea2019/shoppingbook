package cn.edu.jxnu.web.frontend;


import cn.edu.jxnu.domain.ProductTypeDomain;
import cn.edu.jxnu.service.ProductTypeService;
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

@WebServlet(name = "QueryProductTypeServlet", value = "/frontend/gettype.do")
public class QueryProductTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,Object> model=new HashMap<String,Object>();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        ProductTypeService productTypeService=new ImplProductTypeService();
     //图书类型
        List<ProductTypeDomain> typeList=null;
        try {


           // typeList=productTypeService.queryProductType();

            //使用redis优化
            typeList=productTypeService.queryProductTypeFromRedis();

            model.put("success",true);
            model.put("typeList",typeList);

        } catch (Exception e) {
            e.printStackTrace();
            model.put("success",false);
        }
        ObjectMapper objectMapper=new ObjectMapper();
        out.println(objectMapper.writeValueAsString(model));
    }
}
