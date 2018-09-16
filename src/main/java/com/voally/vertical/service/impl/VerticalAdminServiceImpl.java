package com.voally.vertical.service.impl;

import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.UserMapper;
import com.voally.vertical.service.VerticalAdminService;
import com.voally.vertical.util.GlobalFunc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class VerticalAdminServiceImpl extends AbstractService<User> implements VerticalAdminService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Map> getUsers(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userStatus = request.getParameter("status");
        Integer order = GlobalFunc.parseInt(request.getParameter("order"));
        List<Map> list = userMapper.getUsers(userName,userStatus,order);
        return list;
    }
}
