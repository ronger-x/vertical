package com.voally.vertical.service;

import java.util.List;
import java.util.Map;

public interface TagService {

    List<Map> getTags(String tagTitle, String tagStatus, String orderBy);

}
