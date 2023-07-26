package com.magda.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.magda.presentation.db.Db;
import com.magda.presentation.models.Post;
import com.magda.presentation.models.User;

import com.magda.presentation.models.Comment;

@SpringBootApplication
public class PresentationApplication {

  public static void main(String[] args) {

    Db.users.add(new User("kasia", "Kasia", "1970-01-01"));

    Db.users.add(new User("k@rol", "Karol", "1970-01-01"));
    Db.users.add(new User("krysia1", "Krysia", "1970-01-01"));

    Db.posts.add(new Post(1, "Post 1", 1));
    Db.posts.add(new Post(1, "Post 2", 2));
    Db.posts.add(new Post(2, "Post 3", 3));
    Db.posts.add(new Post(2, "Post 4", 4));
    Db.posts.add(new Post(3, "Post 5", 5));
    Db.posts.add(new Post(3, "Post 6", 6));

    Db.comments.add(new Comment(1, 1, "Comment 1", 1));
    Db.comments.add(new Comment(1, 1, "Comment 2", 2));
    Db.comments.add(new Comment(2, 1, "Comment 3", 3));
    Db.comments.add(new Comment(2, 1, "Comment 4", 4));
    Db.comments.add(new Comment(3, 1, "Comment 5", 5));
    Db.comments.add(new Comment(3, 1, "Comment 6", 6));

    SpringApplication.run(PresentationApplication.class, args);
  }

}
