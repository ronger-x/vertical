package com.voally.vertical.service;

import com.voally.vertical.entity.Tag;
import com.voally.vertical.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface VerticalAdminService {
    List<User> getUsers(HttpServletRequest request);

    List<Tag> getTags(HttpServletRequest request);
}
