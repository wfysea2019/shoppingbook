package cn.edu.jxnu.dao;

import cn.edu.jxnu.domain.ProductTypeDomain;

import java.util.List;

public interface ProductTypeDAO {
    /**
     * 取出所有的图书类别
     * @return
     */
    public List<ProductTypeDomain> queryProductType();
}
