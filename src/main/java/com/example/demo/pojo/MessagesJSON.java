package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

// JSON Data structure
@Data
public class MessagesJSON implements Serializable {

    private Long id;
    @NotEmpty
    private String dest ;
    @NotEmpty
    private String author;
    @NotEmpty
    private String content;
    @NotEmpty
    private String dt;
    @NotEmpty
    private Boolean read;
}
