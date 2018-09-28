package com.voally.vertical.service.impl;

import com.voally.vertical.core.service.AbstractService;
import com.voally.vertical.entity.Tag;
import com.voally.vertical.mapper.TagMapper;
import com.voally.vertical.service.TagService;
import com.voally.vertical.util.GlobalFunc;
import com.voally.vertical.util.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class TagServiceImpl extends AbstractService<Tag> implements TagService {

    @Resource
    private TagMapper tagMapper;
    @Value("${env}")
    private String env;

    @Override
    public Map add(String tagTitle) {
        Map map = new HashMap();

        // 校验 tagTitle 是否已存在

        Tag tag = new Tag();
        tag.setTagTitle(tagTitle);
        tag = tagMapper.selectOne(tag);
        if(tag != null && tag.getId()>0){
            map.put("success",false);
            return map;
        }
        tag.setTagTitle(tagTitle);
        tag.setTagURI(GlobalFunc.encode(tagTitle,"UTF-8"));
        tag.setId(Utils.idBuilder());
        tag.setTagDescription("");
        tag.setTagIconPath("");
        tagMapper.insert(tag);

        return map;
    }
}
