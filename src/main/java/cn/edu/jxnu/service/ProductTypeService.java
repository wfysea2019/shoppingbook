package cn.edu.jxnu.service;

import cn.edu.jxnu.domain.ProductTypeDomain;

import java.util.List;

public interface ProductTypeService {
    public List<ProductTypeDomain> queryProductType();

    /**
     * 从redis中获取图书类别的json格式字符串
     * @return
     */
    public List<ProductTypeDomain> queryProductTypeFromRedis();

}
