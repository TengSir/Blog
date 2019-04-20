package edu.hbuas.blog.service;

import edu.hbuas.blog.model.javabean.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    public Users processNormalLogin(HttpServletRequest request, HttpServletResponse response);
    public Users processCookieLogin(HttpServletRequest request, HttpServletResponse response);
    public void rememberUserToCookie(HttpServletRequest request, HttpServletResponse response);
}
