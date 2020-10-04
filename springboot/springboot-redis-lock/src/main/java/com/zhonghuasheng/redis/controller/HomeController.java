package com.zhonghuasheng.redis.controller;

import com.zhonghuasheng.redis.config.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RedisRepository redisRepository;

    @GetMapping("/")
    public String index() {
        return "Hi, this is redis lock";
    }

    @GetMapping("/test")
    public String testConnection() {
        boolean distributedLock = redisRepository.lock("redis-lock-key", "abc");
        return String.valueOf(distributedLock);
    }
}
