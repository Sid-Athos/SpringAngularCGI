package com.example.demo.controller;


import com.example.demo.pojo.LikeJSON;
import com.example.demo.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = {"Like"})
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "likes", produces = MediaType.APPLICATION_JSON_VALUE)
public class LikeController {

    @Resource
    private LikeService likeService; // Methods for the queries

    // Adds a like

    @ApiOperation(value = "Add Like", response = LikeJSON.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LikeJSON addLike(@ApiParam(value = "Like to Add", required = true) @Valid @RequestBody LikeJSON like) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        return likeService.addLike(like);
    }

    // Retrieves author specific like

    @ApiOperation(value = "Get Like by Post")
    @RequestMapping(method = RequestMethod.GET, value = "/like/{post}")
    // FIXME not good path for REST ...
    public LikeJSON getAllById(@ApiParam(value = "Like id",
            required = true) @PathVariable Long id) {
        return likeService.getLikeById(id);
    }
}
