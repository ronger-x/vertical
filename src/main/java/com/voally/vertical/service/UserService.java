package com.voally.vertical.service;

import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.core.service.Service;
import com.voally.vertical.entity.User;

public interface UserService extends Service<User> {
    Thinker profile(String userName);
}
