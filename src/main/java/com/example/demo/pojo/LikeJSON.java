package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

// JSON Data structure
@Data
public class LikeJSON implements Serializable {

    private Long id;
    @NotEmpty
    private Long post;
    @NotEmpty
    private Long author;
}
