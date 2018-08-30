package com.voally.vertical.service.impl;

import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.User;
import com.voally.vertical.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

}
