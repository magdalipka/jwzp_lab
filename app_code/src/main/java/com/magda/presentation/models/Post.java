package com.magda.presentation.models;

import java.util.List;

import com.magda.presentation.db.Db;

public class Post {

  static int nextId = 0;

  public int id;
  public int authorId;
  public String content;
  public int likes;

  public Post(int author, String content, int likes) {
    this.id = nextId++;
    this.authorId = author;
    this.content = content;
    this.likes = likes;
  }

  public static List<Post> getAll() {
    return Db.posts;
  }

  public static Post getById(int id) {
    return Db.posts.stream().filter(post -> post.id == id).findFirst().orElse(null);
  }

  public List<Comment> getComments() {
    return Db.comments.stream().filter(comment -> comment.postId == this.id).toList();
  }

  public static Post addPost(int authorId, String content) {
    Post post = new Post(authorId, content, 0);
    Db.posts.add(post);
    return post;
  }

}
