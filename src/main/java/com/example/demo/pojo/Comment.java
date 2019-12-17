package com.example.demo.pojo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

//see https://fxrobin.developpez.com/tutoriels/java/lombok-retour-experience/

// Table to generate on launch
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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