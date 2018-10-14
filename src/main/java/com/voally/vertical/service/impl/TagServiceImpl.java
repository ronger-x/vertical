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
    public Map add(Tag tag) {
        Map map = new HashMap();
        map.put("success","true");

        // 校验 tagTitle 是否已存在
        Tag newTag = tagMapper.selectOne(tag);
        if(newTag != null && newTag.getId()>0){
            map.put("success","false");
            map.put("message","标签 "+tag.getTagTitle() +" 已存在！");
            return map;
        }else {
            newTag = new Tag();
        }

        newTag.setId(Utils.idBuilder());
        newTag.setTagTitle(tag.getTagTitle());
        newTag.setTagURI(GlobalFunc.encode(tag.getTagTitle(),"UTF-8"));
        newTag.setTagDescription("");
        newTag.setTagIconPath("");
        tagMapper.insert(newTag);
        map.put("id",newTag.getId());
        return map;
    }


    @Override
    public Map updateTag(Tag tag) {
        Map map = new HashMap();
        map.put("success","true");

        Tag oldTag = tagMapper.selectByPrimaryKey(tag.getId());
        if(oldTag.getTagTitle().toUpperCase().equals(tag.getTagTitle().toUpperCase())){
            oldTag.setTagTitle(tag.getTagTitle());
        }
        oldTag.setTagURI(GlobalFunc.encode(tag.getTagURI(),"UTF-8"));
        oldTag.setTagStatus(tag.getTagStatus());
        oldTag.setTagDescription(tag.getTagDescription());
        oldTag.setTagIconPath(tag.getTagIconPath());
        tagMapper.updateByPrimaryKey(oldTag);

        return map;
    }
}
