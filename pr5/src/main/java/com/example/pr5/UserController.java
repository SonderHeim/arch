package com.example.pr5;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable(name = "id") Integer id) {
        try {
            userService.delete(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @PostMapping
    public Integer create(@RequestBody User user) {
        try {
            userService.create(user);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @PutMapping
    public Integer update(@RequestBody User user) {
        try {
            userService.update(user);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
