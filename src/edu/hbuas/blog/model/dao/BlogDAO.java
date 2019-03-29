package edu.hbuas.blog.model.dao;

import edu.hbuas.blog.model.javabean.Blogs;

import java.util.List;

public interface BlogDAO {
    public List<Blogs> listBlogs();
    public Blogs  getBlogDetailById(int blogid);
}
