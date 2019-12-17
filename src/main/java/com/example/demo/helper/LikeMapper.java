package com.example.demo.helper;

import com.example.demo.pojo.Like;
import com.example.demo.pojo.LikeJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikeMapper {
    public Like mapTo(LikeJSON bookJSON) {
        Assert.notNull(bookJSON, "The bookJSON must not be null");
        Like b = new Like();
        // must not set id !
        b.setAuthor(bookJSON.getAuthor());
        b.setPost(bookJSON.getPost());
        return b;
    }
    public LikeJSON mapTo(Like like) {
        Assert.notNull(like, "The book must not be null");
        LikeJSON bJSON = new LikeJSON();
        bJSON.setId(like.getId());
        bJSON.setAuthor(like.getAuthor());
        bJSON.setPost(like.getPost());
        return bJSON;
    }

    public List<LikeJSON> mapTo(List<Like> likeList) {
        Assert.notNull(likeList, "The Likelist must not be null");
        return likeList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
