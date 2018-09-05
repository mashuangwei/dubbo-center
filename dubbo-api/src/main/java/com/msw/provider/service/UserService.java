package com.msw.provider.service;

import com.msw.entity.User;

import java.util.List;

public interface UserService {
    public User getUserById(int id);

    public List<User> getUserList(String name);
}
