package cn.edu.jxnu.service;

import cn.edu.jxnu.domain.ProductDomain;

import java.util.List;

public interface ProductService {
    public List<ProductDomain> queryProductOrderSaleNum(int index, int pageSize) throws Exception;
    public List<ProductDomain> queryProductOrderRand(int index, int pageSize) throws Exception;

    /**
     * 查找pageSize条图书记录
     * @param index
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ProductDomain> queryProductOrderID(int index, int pageSize,String bookName) throws Exception;



    /**
     * 统计图书数量
     * @return
     * @throws Exception
     */
    public int countProductsNumber(String bookName) throws Exception;
}
