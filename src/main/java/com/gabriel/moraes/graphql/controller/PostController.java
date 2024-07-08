package com.gabriel.moraes.graphql.controller;

import com.gabriel.moraes.graphql.model.Post;
import com.gabriel.moraes.graphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //@SchemaMapping(typeName = "Query", value = "postById")
    @QueryMapping
    public Post postById(@Argument String id) {
        return postService.postById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }

}
