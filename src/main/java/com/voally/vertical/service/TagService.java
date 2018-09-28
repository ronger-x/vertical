package com.voally.vertical.service;

import com.voally.vertical.core.service.Service;
import com.voally.vertical.entity.Tag;

import java.util.Map;

public interface TagService extends Service<Tag> {

    Map add(String tagTitle);

}
