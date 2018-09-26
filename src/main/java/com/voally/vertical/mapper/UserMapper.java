package com.voally.vertical.mapper;

import com.voally.vertical.api.entity.Thinker;
import com.voally.vertical.core.mapper.Mapper;
import com.voally.vertical.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {

    Thinker profile(@Param("userName") String userName);

    List<Thinker> getRecommendThinkers();

    List<Map> getUsers(@Param("userName") String userName, @Param("userStatus") String userStatus, @Param("orderBy") String orderBy);
}
