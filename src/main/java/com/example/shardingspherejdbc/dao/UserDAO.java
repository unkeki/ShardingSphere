package com.example.shardingspherejdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingspherejdbc.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO extends BaseMapper<User> {
}
