package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

// JSON Data structure
@Data
public class PostJSON implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !

    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    @NotEmpty
    private String content;
    @NotEmpty
    private String postdate;
}
