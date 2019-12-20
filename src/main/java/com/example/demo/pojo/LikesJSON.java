package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

// JSON Data structure
@Data
public class LikesJSON implements Serializable {

    private Long id;
    @NotEmpty
    private String post;
    @NotEmpty
    private String author;
}
