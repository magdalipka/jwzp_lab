package com.magda.presentation.models;

import com.magda.presentation.db.Db;

public class Comment {

  static int nextId = 0;

  public int id;
  public int postId;
  public int authorId;
  public String content;
  public int likes;

  public Comment(int post, int author, String content, int likes) {
    this.id = nextId++;
    this.postId = post;
    this.authorId = author;
    this.content = content;
    this.likes = likes;
  }

  public static Comment getById(int id) {
    return Db.comments.stream().filter(comment -> comment.id == id).findFirst().orElse(null);
  }

  public static Comment addComment(int postId, int authorId, String content) {
    Comment comment = new Comment(postId, authorId, content, 0);
    Db.comments.add(comment);
    return comment;
  }
}
