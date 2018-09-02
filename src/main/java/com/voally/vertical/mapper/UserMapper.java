package com.voally.vertical.mapper;

import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.core.mapper.Mapper;
import com.voally.vertical.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    Thinker profile(@Param("userName") String userName);

    List<Thinker> getRecommendThinkers();
}
