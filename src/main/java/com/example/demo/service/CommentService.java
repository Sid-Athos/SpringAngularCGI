package com.example.demo.service;

import com.example.demo.helper.CommentMapper;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.CommentJSON;
import com.example.demo.repository.CommentRepository;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;

public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CommentMapper mapper;

//    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "comments", key = "#id")
//    public CommentJSON getCommentById(long id) {
//        //log.info("Called for getCommentById ...");
//        Comment b = commentRepository.getOne(id);
//        return mapper.mapTo(b);
//    }

    public CommentJSON addComment(CommentJSON comment) {
        Comment c = commentRepository.save(mapper.mapTo(comment));
        return mapper.mapTo(c);
    }

    public List<CommentJSON> getAllCommentsByPost(String id) {
        List<Comment> commentList = commentRepository.findByPostId(id);
        return mapper.mapTo(commentList);
    }
}
