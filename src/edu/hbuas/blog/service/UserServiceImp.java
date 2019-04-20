package edu.hbuas.blog.service;

import edu.hbuas.blog.model.dao.UserDAO;
import edu.hbuas.blog.model.dao.UserDAOImp;
import edu.hbuas.blog.model.javabean.Users;
import edu.hbuas.blog.util.MD5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServiceImp implements  UserService {
    private UserDAO  dao;
    public UserServiceImp(){
        dao=new UserDAOImp();
    }



    @Override
    public Users processNormalLogin(HttpServletRequest request, HttpServletResponse response) {
        //1.先获取上一个页面用户输入的账号信息
        String inputCode= request.getParameter("inputCode");

//            if(inputCode.equalsIgnoreCase(request.getSession().getAttribute("code").toString())){
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(username+"\t"+password);
        System.out.println(request.getContextPath());
        //2.查询数据库中有没有这个账户密码对应的用户信息

        Users u=dao.login(username,MD5.genertedPassword(MD5.addSoltToPassword(username,password)));
        System.out.println("查询出来的用use"+u);
        //3.判断查询结果，如果查到该用户则跳转到首页，没有则跳到登陆页面，提示错误消息
        return u;
    }

    @Override
    public Users processCookieLogin(HttpServletRequest request, HttpServletResponse response) {
        String username=null;
        Cookie[]  cs=request.getCookies();
        for(Cookie c:cs){
            if(c.getName().equals("username")){
                username=c.getValue();
                break;
            }
        }
        Users  u=dao.login(username);
        return u;
    }

    @Override
    public void rememberUserToCookie(HttpServletRequest request, HttpServletResponse response) {
        if(request.getParameter("rememberMe")!=null){
            Cookie  c=new Cookie("username",request.getParameter("username"));
            c.setMaxAge(60*60*24*3);
            response.addCookie(c);
        }
    }
}
