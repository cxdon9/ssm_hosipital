package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    public void insert(User user);

    public User selectByName(User user);
}
