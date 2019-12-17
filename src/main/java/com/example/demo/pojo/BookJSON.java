package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class BookJSON implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !

    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    @NotEmpty
    private String troubles;
}
