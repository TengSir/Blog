package edu.hbuas.blog.control;

import edu.hbuas.blog.model.dao.BlogDAO;
import edu.hbuas.blog.model.dao.BlogDAOImp;
import edu.hbuas.blog.model.javabean.Blogs;
import edu.hbuas.blog.model.javabean.PageBean;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
			}case "listBlogsByAjaxPage":{
                listBlogsByAjaxPage(request,response);
                break;
            }

		}
	}
    /**
     * 这个ajax分页的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void listBlogsByAjaxPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page=request.getParameter("page");
        String count=request.getParameter("count");

        try {
            List<Blogs> bs=blogDAO.listBlogsByPage(Integer.parseInt(page),Integer.parseInt(count));
            //使用json项目提供当json。jar里面当api方法，将后台获取当java集合以及对象转成标准当json格式数据返回给前台

            JSONArray  allBlogsJson=new JSONArray();

            for(Blogs  b:bs){
                JSONObject jsonObj=new JSONObject();
                jsonObj.put("blogid",b.getBlogid());
                jsonObj.put("title",b.getTitle());
                jsonObj.put("content",b.getContent().length()>40?b.getContent().substring(0,40):b.getContent());
                jsonObj.put("publishTime",b.getPublishtime());
                jsonObj.put("visitedCount",b.getVisitedcount());
                jsonObj.put("image","images/201610181739277776.jpg");
				jsonObj.put("userimage",b.getUser().getImage());
				jsonObj.put("nickname",b.getUser().getNickname());
				jsonObj.put("userid",b.getUser().getUserid());

                allBlogsJson.put(jsonObj);

            }

            response.setContentType("text/json;charset=utf-8");
            PrintWriter out=response.getWriter();

            out.write( allBlogsJson.toString());

            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
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

//		response.setContentType("text/json;charset=utf-8");
//		String[]  ts={"奔驰里偶遇123","许许许三多","sfxxfsd","sdfsdfsfsdf"};
//		PrintWriter out=response.getWriter();
//		out.write("[");
//
//		StringBuffer  s=new StringBuffer();
//		for(String k:ts){
//			s.append("\""+k+"\",");
//
//		}
//		s.delete(s.length()-1,s.length());
//		out.write(s.toString());
//		out.write("]");
//		out.flush();
//		out.close();



//
//		String key="奔驰漏油";
//
//		//ArrayList<String> titles=dao.searchByKey(key);
//
//		String[]  ts={"奔驰里偶遇123","许许许三多","sfxxfsd","sdfsdfsfsdf"};
//
//		PrintWriter out=response.getWriter();
//		out.write("<?xml version='1.0' encoding='utf-8' ?>");
//		out.write("<blogs>");
//
//		out.write("<blog>");
//		out.write("<blogid>1</blogid>");
//		out.write("<blogtitle>234</blogtitle>");
//		out.write("<publishtime>sdfsfd</publishtime>");
//		out.write("</blog>");
//		out.write("<blog>");
//		out.write("<blogid>1</blogid>");
//		out.write("<blogtitle>234</blogtitle>");
//		out.write("<publishtime>sdfsfd</publishtime>");
//		out.write("</blog>");
//		out.write("<blog>");
//		out.write("<blogid>1</blogid>");
//		out.write("<blogtitle>234</blogtitle>");
//		out.write("<publishtime>sdfsfd</publishtime>");
//		out.write("</blog>");
//
////		for(String k:ts){
////			out.write("<title>"+k+"</title>");
////		}
//		out.write("</blogs>");
//
//		out.flush();
//		out.close();
	}

	/**
	 * 这个方法是查询热门博客的业务方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void listTopBlogs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		String count=request.getParameter("count");

		//这里必须封装一个分页bean，将于分页有关的属性全部封装进去
		PageBean p=new PageBean();
		p.setAllCount(blogDAO.getAllCountOfBlogs());
		int allPages=p.getAllCount()%Integer.parseInt(count)==0?p.getAllCount()/Integer.parseInt(count):p.getAllCount()/Integer.parseInt(count)+1;
		p.setAllPages(allPages);
		p.setFirstPage(1);
		p.setNowPage(Integer.parseInt(page));
		p.setNextPage(p.getNowPage()==p.getAllPages()?p.getAllPages():p.getNowPage()+1);
		p.setPreviousPage(Integer.parseInt(page)>1?Integer.parseInt(page)-1:1);

		p.setEveryPageCount(Integer.parseInt(count));

		request.setAttribute("pageBean",p);




		try {
			List<Blogs> bs=blogDAO.listBlogsByPage(Integer.parseInt(page),Integer.parseInt(count));

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
