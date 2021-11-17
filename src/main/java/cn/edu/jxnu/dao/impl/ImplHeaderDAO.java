package cn.edu.jxnu.dao.impl;

import cn.edu.jxnu.dao.HeaderDAO;
import cn.edu.jxnu.domain.HeaderDomain;
import cn.edu.jxnu.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ImplHeaderDAO implements HeaderDAO {

    JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<HeaderDomain> getHeader() {
        String sql="select * from header_table;";
        List<HeaderDomain> headerDomains=jdbcTemplate.query(sql,new BeanPropertyRowMapper<HeaderDomain>(HeaderDomain.class));
        return headerDomains;
    }
}
