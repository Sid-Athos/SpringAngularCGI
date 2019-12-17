package com.example.demo.helper;

import com.example.demo.pojo.Comment;
import com.example.demo.pojo.CommentJSON;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public Comment mapTo(CommentJSON commentJSON) {
        Assert.notNull(commentJSON, "The commentJSON must not be null");
        Comment b = new Comment();
        // must not set id !
        b.setAuthor(commentJSON.getAuthor());
        b.setContent(commentJSON.getContent());
        return b;
    }

    public CommentJSON mapTo(Comment comment) {
        Assert.notNull(comment, "The comment must not be null");
        CommentJSON bJSON = new CommentJSON();
        bJSON.setAuthor(comment.getAuthor());
        bJSON.setId(comment.getId());
        bJSON.setIdPost(comment.getIdPost());
        bJSON.setContent(comment.getContent());
        return bJSON;
    }

    public List<CommentJSON> mapTo(List<Comment> commentList) {
        Assert.notNull(commentList, "The commentList must not be null");
        return commentList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
