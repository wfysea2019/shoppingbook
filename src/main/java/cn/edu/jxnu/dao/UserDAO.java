package cn.edu.jxnu.dao;

import cn.edu.jxnu.domain.UserDomain;

import java.sql.SQLException;

public interface UserDAO {

    /**
     * 根据用户名和密码查找该用户信息
     * @param username
     * @param pwd
     * @return
     * @throws SQLException
     */
    public UserDomain findUser(String username, String pwd) throws SQLException;

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public int insertUser(UserDomain user) throws SQLException;


    /**
     * 根据用户名找用户信息
     * @param username
     * @return
     * @throws SQLException
     */
    public UserDomain findUser(String username) throws SQLException;

    /**
     * 根据随机码，将state从0改为1
     * @param randomNum
     * @return
     * @throws SQLException
     */
    public int updateUserState(String randomNum) throws  SQLException;

    /**
     * 根据随机码，查找该用户信息
     * @param randomNum
     * @return
     * @throws SQLException
     */
    public UserDomain findUserByRandomNum(String randomNum) throws SQLException;

}
