package edu.hbuas.blog.model.dao;

import edu.hbuas.blog.model.javabean.Blogs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOImp extends  BaseDAOImp implements BlogDAO {
    @Override
    public int getAllCountOfBlogs() {
        int result=0;
        ResultSet rs=null;
        try {
             rs=getSta().executeQuery("select count(blogid) from blogs");
             rs.next();
             result=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Blogs> listBlogsByPage(int page,int count) {
        List<Blogs> bs=new ArrayList<>();
        try {
            ResultSet rs=getSta().executeQuery("select *  from blogs limit "+(page-1)*count+","+count);
            while(rs.next()){
                Blogs b=new Blogs();
                b.setBlogid(rs.getInt("blogid"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setPublishtime(rs.getString("publishtime"));
                b.setVisitedcount(rs.getInt("visitedcount"));
                bs.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }

    @Override
    public Blogs getBlogDetailById(int blogid) {
        Blogs b=null;
        try {
            PreparedStatement pre=getPre("select *  from blogs where blogid=?");
            pre.setInt(1,blogid);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                 b=new Blogs();
                b.setBlogid(rs.getInt("blogid"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setPublishtime(rs.getString("publishtime"));
                b.setVisitedcount(rs.getInt("visitedcount"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
}
