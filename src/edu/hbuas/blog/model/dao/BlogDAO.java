package edu.hbuas.blog.model.dao;

import edu.hbuas.blog.model.javabean.Blogs;

import java.util.List;

public interface BlogDAO {
    public List<Blogs> listBlogsByPage(int page,int count);
    public Blogs  getBlogDetailById(int blogid);
    public int getAllCountOfBlogs();
}
