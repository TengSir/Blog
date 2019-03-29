package edu.hbuas.blog.control;

import edu.hbuas.blog.model.dao.BlogDAO;
import edu.hbuas.blog.model.dao.BlogDAOImp;
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
import java.util.List;

@WebServlet(name = "BlogServlet",urlPatterns = "/BlogServlet")
public class BlogServlet extends HttpServlet {
    private BlogDAO blogDAO;

    @Override
    public void init() throws ServletException {
        blogDAO=new BlogDAOImp();

    }

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
        String blogid=request.getParameter("blogid");
        try {
          Blogs b=blogDAO.getBlogDetailById(Integer.parseInt(blogid));

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
        try {
         List<Blogs> bs=blogDAO.listBlogs();

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
