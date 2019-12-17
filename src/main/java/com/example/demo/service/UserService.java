package com.example.demo.service;

import com.example.demo.helper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserJSON;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    public List<UserJSON> getAllUsers() {
        log.info("Called for getAllUsers ...");
        List<User> bookList = userRepository.findAll();
        return userMapper.mapTo(bookList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "users", key =
            "#id")
    public UserJSON getUserById(long id) {
        log.info("Called for getUserById ...");
        User b = userRepository.getOne(id);
        return userMapper.mapTo(b);
    }

    public UserJSON addUser(UserJSON book) {
        User b = userRepository.save(userMapper.mapTo(book));
        return userMapper.mapTo(b);
    }

    public List<UserJSON> getAllUsersByMail(String author) {
        List<User> bookList = userRepository.findByMail(author);
        return userMapper.mapTo(bookList);
    }

    public List<UserJSON> getAllUsersByName(String title) {
        List<User> bookList = userRepository.findByName(title);
        return userMapper.mapTo(bookList);
    }
}
