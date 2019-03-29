package edu.hbuas.blog.model.dao;

import edu.hbuas.blog.model.javabean.Users;

public interface UserDAO {
    public Users  login(String username,String password);//调用时都要建立一次数据库链接
    public Users  login(String username);//调用时都要建立一次数据库链接
    public boolean register(Users user);
}
