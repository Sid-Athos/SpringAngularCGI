package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

// JSON Data structure
@Data
public class CommentJSON implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !

    private Long id;
    @NotEmpty
    private String idPost;
    @NotEmpty
    private String title;
    @NotEmpty
    private Date date;
    @NotEmpty
    private String author;
    @NotEmpty
    private String content;
}
