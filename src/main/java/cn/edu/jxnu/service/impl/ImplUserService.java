package cn.edu.jxnu.service.impl;

import cn.edu.jxnu.dao.UserDAO;
import cn.edu.jxnu.dao.impl.ImplUserDAO;
import cn.edu.jxnu.domain.UserDomain;
import cn.edu.jxnu.service.UserService;

import java.sql.SQLException;

public class ImplUserService implements UserService {

    private UserDAO userDAO=new ImplUserDAO();
    @Override
    public UserDomain findUser(String username, String pwd) throws SQLException {
        return userDAO.findUser(username,pwd);
    }

    @Override
    public int insertUser(UserDomain user) throws SQLException {
        return userDAO.insertUser(user);
    }

    @Override
    public UserDomain findUser(String username) throws SQLException {
        return userDAO.findUser(username);
    }

    @Override
    public int updateUserState(String randomNum) throws SQLException {
        return userDAO.updateUserState(randomNum);
    }
}
