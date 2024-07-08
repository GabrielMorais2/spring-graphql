package com.gabriel.moraes.graphql.controller;

import com.gabriel.moraes.graphql.model.Comment;
import com.gabriel.moraes.graphql.model.Post;
import com.gabriel.moraes.graphql.service.CommentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId) {
        return commentService.createComment(content, postId);
    }

    @SchemaMapping
    public Collection<Comment> comments(Post post) {
        return commentService.findByPost(post.id());
    }
}
