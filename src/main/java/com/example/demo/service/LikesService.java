package com.example.demo.service;

import com.example.demo.helper.LikesMapper;
import com.example.demo.pojo.Likes;
import com.example.demo.pojo.LikesJSON;
import com.example.demo.repository.LikesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// SQL methods resources
@Slf4j
@Service
public class LikesService {

    @Resource
    private LikesRepository likesRepository;

    @Resource
    private LikesMapper likesMapper;

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "likes", key = "#post")
    public List<LikesJSON> getLikesByPost(long post) {
        //log.info("Called for getLikeByPost ...");
        List<Likes> b = likesRepository.findByPost(post);
        return likesMapper.mapTo(b);
    }

    public LikesJSON addLike(LikesJSON likes) {
        Likes l = likesRepository.save(likesMapper.mapTo(likes));
        return likesMapper.mapTo(l);
    }

}
