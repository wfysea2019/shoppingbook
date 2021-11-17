package cn.edu.jxnu.dao;

import cn.edu.jxnu.domain.ProductDomain;

import java.util.List;

public interface ProductDAO {

    /**
     * 统计图书数量
     */
    public int countProductsNumber() throws Exception;

    /**
     * 统计包含该书名的图书数量
     * @param bookName
     * @return
     * @throws Exception
     */
    public int countProductsNumber(String bookName) throws Exception;
    /**
     *  根据销售量显示记录
     * @param index
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ProductDomain> queryProductOrderSaleNum(int index, int pageSize) throws Exception;

    /**
     * 根据ID号显示
     * @param index
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ProductDomain> queryProductOrderID(int index, int pageSize) throws Exception;

    /**
     * 根据ID号显示
     * @param index
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ProductDomain> queryProductOrderID(int index, int pageSize,String bookName) throws Exception;

    /**
     *  随机抽取pagesize个商品
     * @param index
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ProductDomain> queryProductOrderRand(int index, int pageSize) throws Exception;


}
