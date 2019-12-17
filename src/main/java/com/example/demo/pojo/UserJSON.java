package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserJSON implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String pwd;
    @NotEmpty
    private String mail;
}
