package com.magda.presentation.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.magda.presentation.models.Comment;
import com.magda.presentation.models.Post;

@Controller
public class PostController {
  @QueryMapping
  public Post postById(@Argument int id) {
    return Post.getById(id);
  }

  @QueryMapping
  public List<Post> posts() {
    return Post.getAll();
  }

  @SchemaMapping(typeName = "Post")
  public List<Comment> comments(Post post) {
    return post.getComments();
  }

  @SchemaMapping(typeName = "Post")
  public String text(Post post) {
    return "Post author: " + post.authorId;
  }

  @MutationMapping
  public Post addPost(@Argument int authorId, @Argument String content) {
    return Post.addPost(authorId, content);
  }

}