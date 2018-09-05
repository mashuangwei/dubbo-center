package com.msw.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.msw.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setAddress("beijing");
        user.setAge(19);
        user.setId(1);
        user.setName("高圆圆");
        return user;
    }

    @Override
    public List<User> getUserList(String name) {
        User user = new User();
        user.setAddress("beijing");
        user.setAge(19);
        user.setId(1);
        user.setName("高圆圆");
        User user1 = new User();
        user.setAddress("台湾");
        user.setAge(23);
        user.setId(2);
        user.setName("林志玲");
        List<User> mylist = new ArrayList<>();
        mylist.add(user);
        mylist.add(user1);
        return mylist;
    }
}
