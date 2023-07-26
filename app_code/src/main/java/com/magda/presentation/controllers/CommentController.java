package com.magda.presentation.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.magda.presentation.models.Comment;

@Controller
public class CommentController {

  @QueryMapping
  public Comment commentById(@Argument int id) {
    return Comment.getById(id);
  }

  @MutationMapping
  public Comment addComment(@Argument int postId, @Argument int authorId, @Argument String content) {
    var comment = Comment.addComment(postId, authorId, content);
    return comment;
  }

}