package edu.hbuas.blog.model.dao;

import edu.hbuas.blog.model.javabean.Users;

public interface UserDAO {
    public Users  login(String username,String password);
    public boolean register(Users user);
}
