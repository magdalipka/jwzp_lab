package com.magda.presentation.db;

import java.util.LinkedList;
import java.util.List;

import com.magda.presentation.models.Comment;
import com.magda.presentation.models.Post;
import com.magda.presentation.models.User;

public class Db {

  static public List<User> users = new LinkedList<User>();
  static public List<Post> posts = new LinkedList<Post>();
  static public List<Comment> comments = new LinkedList<Comment>();

}
