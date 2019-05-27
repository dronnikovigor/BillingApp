package com.axamit.billingapp.controller;

import com.axamit.billingapp.model.User;
import com.axamit.billingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    /**
     * Load the new user page.
     * @param model
     * @return
     */
    @GetMapping("user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }
    /**
     * Create a new user.
     * @param user
     * @param model
     * @return
     */
    @PostMapping("/user")
    public String createUser(User user, Model model) {
        userRepository.save(user);
        return "redirect:/user/" + user.getId();
    }
    /**
     * Get a user by ID.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(new User()));
        return "user";
    }
    /**
     * Get all users.
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
    /**
     * Load the edit user page for the user with the specified ID.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(new User()));
        return "userform";
    }
    /**
     * Update a user.
     * @param user
     * @return
     */
    @PostMapping("/user/{id}")
    public String updateUser(User user) {
        userRepository.save(user);
        return "redirect:/user/" + user.getId();
    }
    /**
     * Delete a user by ID.
     * @param id
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable  Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}