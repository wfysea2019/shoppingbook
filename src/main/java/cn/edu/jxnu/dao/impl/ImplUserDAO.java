package cn.edu.jxnu.dao.impl;

import cn.edu.jxnu.dao.UserDAO;
import cn.edu.jxnu.domain.UserDomain;
import cn.edu.jxnu.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ImplUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public UserDomain findUser(String username, String pwd) throws SQLException {

        List<UserDomain> list=null;
        String sql="select *\n" +
                "from customer_table\n" +
                "where cust_no=? and cust_pwd=?;";

        list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<UserDomain>(UserDomain.class),username,pwd);

        if (list==null || list.size()==0)
            return null;
        else
            return list.get(0);
    }

    @Override
    public int insertUser(UserDomain user) throws SQLException {
//        String sql="insert into customer_table(cust_no,cust_pwd,last_login,email,state)\n" +
//                "values(?,?,?,?,?)";
        //增加随机码字段的插入操作
        String sql="insert into customer_table(cust_no,cust_pwd,last_login,email,state,random_num)\n" +
                "values(?,?,?,?,?,?)";
//        return jdbcTemplate.update(sql,user.getCustNo(),user.getCustPwd(),user.getLastLogin(),user.getEmail(),0);
        return jdbcTemplate.update(sql,user.getCustNo(),user.getCustPwd(),user.getLastLogin(),user.getEmail(),0,user.getRandomNum());


    }

    @Override
    public UserDomain findUser(String username) throws SQLException {
        UserDomain user=null;
        String sql="select *\n" +
                "from customer_table\n" +
                "where cust_no=?;";

        try {
            user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UserDomain>(UserDomain.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUserState(String randomNum) throws  SQLException{
        String  sql="\n" +
                "update customer_table\n" +
                "set state=1\n" +
                "where state=0 and random_num=?";

        return jdbcTemplate.update(sql,randomNum);
    }

    @Override
    public UserDomain findUserByRandomNum(String randomNum) throws SQLException {
        return null;
    }
}
