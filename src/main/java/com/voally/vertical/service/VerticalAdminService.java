package com.voally.vertical.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface VerticalAdminService {
    List<Map> getUsers(HttpServletRequest request);

    List<Map> getTags(HttpServletRequest request);
}
