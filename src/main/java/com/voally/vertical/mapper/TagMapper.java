package com.voally.vertical.mapper;

import com.voally.vertical.entity.Tag;
import com.voally.vertical.core.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TagMapper extends Mapper<Tag> {

    List<Map> getTags(@Param("tagTitle") String tagTitle, @Param("tagStatus") String tagStatus, @Param("orderBy") String orderBy);
}
