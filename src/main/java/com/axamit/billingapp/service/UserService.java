package com.axamit.billingapp.service;

import com.axamit.billingapp.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
