package com.example.demo.helper;

import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;
// Some JSON parser equivalent for JSON queries
@Component
public class Mapper {

    public Post mapTo(PostJSON postJSON) {
        Assert.notNull(postJSON, "The bookJSON must not be null");
        Post b = new Post();
        // must not set id !
        b.setTitle(postJSON.getTitle());
        b.setAuthor(postJSON.getAuthor());
        b.setContent(postJSON.getContent());
        return b;
    }

    public PostJSON mapTo(Post book) {
        Assert.notNull(book, "The book must not be null");
        PostJSON bJSON = new PostJSON();
        bJSON.setTitle(book.getTitle());
        bJSON.setAuthor(book.getAuthor());
        bJSON.setId(book.getId());
        bJSON.setContent(book.getContent());
        return bJSON;
    }

    public List<PostJSON> mapTo(List<Post> bookList) {
        Assert.notNull(bookList, "The bookList must not be null");
        return bookList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
