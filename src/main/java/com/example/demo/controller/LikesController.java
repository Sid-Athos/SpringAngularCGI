package com.example.demo.controller;

import com.example.demo.pojo.LikesJSON;
import com.example.demo.service.LikesService;
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
public class LikesController {

    @Resource
    private LikesService likesService; // Methods for the queries

    // Adds a likes

    @ApiOperation(value = "Add Likes", response = LikesJSON.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LikesJSON addLike(@ApiParam(value = "Likes to Add", required = true) @Valid @RequestBody LikesJSON likes) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        return likesService.addLike(likes);
    }

    // Retrieves author specific like

    @ApiOperation(value = "Get Likes by Post")
    @RequestMapping(method = RequestMethod.GET, value = "/likes/{post}")
    // FIXME not good path for REST ...
    public List<LikesJSON> getLikesByPost(@ApiParam(value = "Likes post",
            required = true) @PathVariable Long post) {
        return likesService.getLikesByPost(post);
    }
}
