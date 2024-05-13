package com.example.shardingspherejdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingspherejdbc.dao.UserDAO;
import com.example.shardingspherejdbc.po.User;
import com.example.shardingspherejdbc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingSphereJdbcApplicationTests {

    @Autowired
    private UserDAO userDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void insertTest() {
        for (int i = 1; i <= 100; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setSex("男");
            userDAO.insert(user);
        }
    }

    @Test
    public void selectByIdTest() {
        System.out.println(userDAO.selectById(996117951545344001L));
    }

    @Test
    public void selectByNameTest() {
        QueryWrapper<User> qy = new QueryWrapper<>();
        qy.eq("name","test1");
        userDAO.selectList(qy);
    }
}
