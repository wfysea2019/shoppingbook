package cn.edu.jxnu.service.impl;

import cn.edu.jxnu.dao.ProductDAO;
import cn.edu.jxnu.dao.impl.ImplProdutctDAO;
import cn.edu.jxnu.domain.ProductDomain;
import cn.edu.jxnu.service.ProductService;

import java.util.List;
import java.util.Locale;

public class ImplProductService  implements ProductService {
    private ProductDAO dao=new ImplProdutctDAO();
    public List<ProductDomain> queryProductOrderSaleNum(int index, int pageSize)  throws Exception{

        return dao.queryProductOrderSaleNum(index,pageSize);
    }



    public List<ProductDomain> queryProductOrderRand(int index, int pageSize) throws Exception{
        return dao.queryProductOrderRand(index,pageSize);
    }


    @Override
    public List<ProductDomain> queryProductOrderID(int index, int pageSize,String bookName) throws Exception{
        if (bookName==null || bookName.trim().equals(""))
        return dao.queryProductOrderID(index,pageSize);
        else
            return dao.queryProductOrderID(index,pageSize,bookName);
    }
    @Override
    public int countProductsNumber(String bookName) throws Exception {
        if (bookName==null || bookName.trim().equals(""))
            return dao.countProductsNumber();
        else
            return dao.countProductsNumber(bookName);
    }
}
