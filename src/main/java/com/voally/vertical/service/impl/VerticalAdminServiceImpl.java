package com.voally.vertical.service.impl;

import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.Tag;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.TagMapper;
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
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<User> getUsers(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userStatus = request.getParameter("userStatus");
        String orderBy = request.getParameter("orderBy");
        List<User> list = userMapper.getUsers(userName,userStatus,orderBy);
        return list;
    }

    @Override
    public List<Tag> getTags(HttpServletRequest request) {
        String tagTitle = request.getParameter("tagTitle");
        String tagStatus = request.getParameter("tagStatus");
        String orderBy = request.getParameter("orderBy");
        List<Tag> list = tagMapper.getTags(tagTitle,tagStatus,orderBy);
        return list;
    }
}
