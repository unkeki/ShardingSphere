package com.example.shardingspherejdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingspherejdbc.dao.UserDAO;
import com.example.shardingspherejdbc.po.User;
import com.example.shardingspherejdbc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {


}
