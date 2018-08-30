package com.voally.vertical.service.impl;

import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.User;
import com.voally.vertical.mapper.UserMapper;
import com.voally.vertical.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Thinker profile(String userName) {
        return userMapper.profile(userName);
    }
}
