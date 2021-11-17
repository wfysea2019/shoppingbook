package cn.edu.jxnu.service;

import cn.edu.jxnu.domain.UserDomain;

import java.sql.SQLException;

public interface UserService {
    public UserDomain findUser(String username, String pwd) throws SQLException;

    public int insertUser(UserDomain user) throws SQLException;

    public UserDomain findUser(String username) throws SQLException;

    /**
     * 根据随机码，将state从0改为1
     * @param randomNum
     * @return
     * @throws SQLException
     */
    public int updateUserState(String randomNum) throws  SQLException;
}
