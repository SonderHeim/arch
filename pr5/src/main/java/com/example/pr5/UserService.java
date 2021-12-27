package com.example.pr5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public void create(User user) {
        user.setId(null);
        userRepository.save(user);
    }

    public void update(User user) {
        User prevUser = userRepository.findById(user.getId()).get();

        if (user.getFullName() == null) {
            user.setFullName(prevUser.getFullName());
        }

        if (user.getAge() == null) {
            user.setAge(prevUser.getAge());
        }

        if (user.getGender() == null) {
            user.setGender(prevUser.getGender());
        }

        if (user.getAddress() == null) {
            user.setAddress(prevUser.getAddress());
        }

        userRepository.save(user);
    }
}
