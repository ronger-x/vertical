package com.voally.vertical.service.impl;

import com.voally.vertical.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TagServiceImpl implements TagService {



    @Override
    public List<Map> getTags(String tagTitle, String tagStatus, String orderBy) {
        return null;
    }
}
