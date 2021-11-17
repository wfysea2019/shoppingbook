package cn.edu.jxnu.service.impl;

import cn.edu.jxnu.dao.HeaderDAO;
import cn.edu.jxnu.dao.impl.ImplHeaderDAO;
import cn.edu.jxnu.domain.HeaderDomain;
import cn.edu.jxnu.service.HeaderService;

import java.util.List;

public class ImplHeaderService implements HeaderService {
    private HeaderDAO headerDAO=new ImplHeaderDAO();
    @Override
    public List<HeaderDomain> getHeader() {
        return headerDAO.getHeader();
    }
}
