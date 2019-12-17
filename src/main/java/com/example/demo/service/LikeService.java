package com.example.demo.service;

import com.example.demo.helper.LikeMapper;
import com.example.demo.pojo.Like;
import com.example.demo.pojo.LikeJSON;
import com.example.demo.repository.LikeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// SQL methods resources
@Slf4j
@Service
public class LikeService {

    @Resource
    private LikeRepository likeRepository;

    @Resource
    private LikeMapper likeMapper;

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "like", key = "#id")
    public LikeJSON getLikeById(long id) {
        //log.info("Called for getLikeByPost ...");
        Like b = (Like) likeRepository.findByPost(id);
        return likeMapper.mapTo(b);
    }

    public LikeJSON addLike(LikeJSON like) {
        Like l = likeRepository.save(likeMapper.mapTo(like));
        return likeMapper.mapTo(l);
    }

}
