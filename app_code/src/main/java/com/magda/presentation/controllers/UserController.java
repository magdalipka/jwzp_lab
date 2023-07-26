package com.magda.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.magda.presentation.models.Post;
import com.magda.presentation.models.User;

import graphql.schema.DataFetchingEnvironment;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

  @Autowired
  private HttpServletRequest request;

  @QueryMapping
  public User userById(@Argument String id) {
    return User.getById(id);
  }

  @QueryMapping
  public List<User> users(DataFetchingEnvironment env) {
    env.getGraphQlContext().put("authRole", request.getHeader("hello"));
    return User.getAll();
  }

  @SchemaMapping(typeName = "User")
  public String nick(User user, @Argument("uppercased") Boolean uppercased) {
    return uppercased ? user.nick.toUpperCase() : user.nick;
  }

  @SchemaMapping(typeName = "User")
  public List<Post> posts(User user) {
    return user.getPosts();
  }

  @MutationMapping
  public User addUser(@Argument String nick, @Argument String displayedName, @Argument String birthday) {
    return User.addUser(nick, displayedName, birthday);
  }

}