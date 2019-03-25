package edu.hbuas.blog.control;

import edu.hbuas.blog.model.javabean.Blogs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "BlogServlet",urlPatterns = "/BlogServlet")
public class BlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String method=request.getParameter("method");
        switch (method){
            case "listTopBlogs":{
                listTopBlogs(request,response);
                break;
            }
            case "getDetailOfBlogById":{
                getDetailOfBlogById(request,response);
                break;
            }

        }
    }

    /**
     * 根据帖子id查询帖子详情的业务方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getDetailOfBlogById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查询帖子详情的方法");
        String blogid=request.getParameter("blogid");
        System.out.println("取出来的blogid"+blogid);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.查询数据库中有没有这个账户密码对应的用户信息
            Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Blog?characterEncoding=UTF8","root","");

            PreparedStatement pre=con.prepareStatement("select * from blogs  where blogid=?");
            pre.setInt(1,Integer.parseInt(blogid));
            ResultSet rs= pre.executeQuery();
            Blogs  b=new Blogs();
            if(rs.next()){

                b.setBlogid(rs.getInt("blogid"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setPublishtime(rs.getString("publishtime"));
                b.setVisitedcount(rs.getInt("visitedcount"));
            }

            request.setAttribute("blog",b);
            request.getRequestDispatcher("show.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 这个方法是查询热门博客的业务方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void listTopBlogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到这个方法了！");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.查询数据库中有没有这个账户密码对应的用户信息
            Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Blog?characterEncoding=UTF8","root","");

            PreparedStatement pre=con.prepareStatement("select * from blogs order by blogid desc ");
            ResultSet rs= pre.executeQuery();

            ArrayList<Blogs> bs=new ArrayList<>();

            while(rs.next()){
                Blogs  b=new Blogs();
                b.setBlogid(rs.getInt("blogid"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setPublishtime(rs.getString("publishtime"));
                b.setVisitedcount(rs.getInt("visitedcount"));
                System.out.println(b);
                bs.add(b);
            }

            request.setAttribute("allBlogs",bs);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
