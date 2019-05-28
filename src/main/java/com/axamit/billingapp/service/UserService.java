package com.axamit.billingapp.service;

import com.axamit.billingapp.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Iterable<User> findByPhone(long phone);
    Optional<User> findById(Long id);
    void saveUser(User user);
    void deleteById(Long id);
}
