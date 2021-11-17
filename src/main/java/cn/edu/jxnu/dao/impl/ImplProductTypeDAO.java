package cn.edu.jxnu.dao.impl;


import cn.edu.jxnu.dao.ProductTypeDAO;
import cn.edu.jxnu.domain.ProductTypeDomain;
import cn.edu.jxnu.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ImplProductTypeDAO implements ProductTypeDAO {
    //获取JdbcTemplate对象
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<ProductTypeDomain> queryProductType() {

        List<ProductTypeDomain> list=null;
        //String sql="select * from booktype_table";
        String sql="select *  from booktype_table";
        list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductTypeDomain>(ProductTypeDomain.class));
        return list;
    }
}
