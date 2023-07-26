package com.magda.presentation.models;

import java.util.List;

import com.magda.presentation.db.Db;

public class User {

  static int nextId = 0;

  public int id;
  public String nick;
  public String displayedName;
  public String birthday;

  public User(String nick, String displayedName, String birthday) {
    this.id = nextId++;
    this.nick = nick;
    this.displayedName = displayedName;
    this.birthday = birthday;
  }

  public static List<User> getAll() {
    return Db.users;
  }

  public static User getById(String id) {
    return Db.users.stream().filter(user -> user.nick.equals(id)).findFirst().orElse(null);
  }

  public List<Post> getPosts() {
    return Db.posts.stream().filter(post -> post.authorId == this.id).toList();
  }

  public static User addUser(String nick, String displayedName, String birthday) {
    User user = new User(nick, displayedName, birthday);
    Db.users.add(user);
    return user;
  }

}
