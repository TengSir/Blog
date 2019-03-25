package edu.hbuas.blog.control;

import edu.hbuas.blog.model.dao.UserDAO;
import edu.hbuas.blog.model.dao.UserDAOImp;
import edu.hbuas.blog.model.javabean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * 自定义的servlet我们把doget和dopost请求合二为一，然后自己通过请求的方法参数来对不同的业务请求分流到不同的自定义方法中
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDAO  userDAO;

    @Override
    public void init() throws ServletException {
        userDAO=new UserDAOImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //为了让一个servlet能应对前端的多个业务方法请求，我们不得不对serlvet做方法复用.
        //前端我们通过每次请求过来的时候传入一个名字为method参数，通过判断参数的值来知道用户点击了哪个请求，然后调用对应的自定义的方法
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String method=request.getParameter("method");
        switch (method){
            case "login":{
                login(request,response);
                break;
            }
            case "logoff":{
                logoff(request,response);
                break;
            }
            case "register":{
                register(request,response);
                break;
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * 这是用户注册的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单上用户输入的要注册的用户信息
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String nickname= request.getParameter("nickname");
        String sex= request.getParameter("sex");
        String age= request.getParameter("age");
        System.out.println(username+"\t"+password+"\t"+nickname+"\t"+sex+"\t"+age);
        //2.链接数据库，将用户填写的资料插入到用户信息表，生成一条新的用户u 记录信息

        Users  u=new Users();
        u.setUsername(username);
        u.setPassword(password);
        u.setNickname(nickname);
        u.setSex(Long.parseLong(sex));
        u.setAge(Long.parseLong(age));
        try {
          boolean result=userDAO.register(u);

            //3.判断插入语句的执行结果，跳转到页面提示响应的信息
            if(result){
                response.sendRedirect("login.jsp");
            }else{
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
        }


    }

    /**
     * 自定义的处理退出登陆的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logoff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();//销毁session中所有的数据
        System.out.println("退出登陆的方法");
        response.sendRedirect("index.jsp");

    }

    /**
     * 自定义的处理登陆业务的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.先获取上一个页面用户输入的账号信息
        String inputCode= request.getParameter("inputCode");

        if(inputCode.equalsIgnoreCase(request.getSession().getAttribute("code").toString())){
            String username= request.getParameter("username");
            String password= request.getParameter("password");
            System.out.println("登陆的方法：\t"+username+"\t\t"+password);

            System.out.println(request.getContextPath());
            try {
                //2.查询数据库中有没有这个账户密码对应的用户信息

                Users u=userDAO.login(username,password);
                //3.判断查询结果，如果查到该用户则跳转到首页，没有则跳到登陆页面，提示错误消息

                if(u!=null){
                    //这就是后台执行业务完成后，跳转页面的方法
                    request.getSession().setAttribute("user",u);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }else{
                    request.setCharacterEncoding("utf-8");
                    response.setCharacterEncoding("utf-8");
                    request.setAttribute("errorMessage","用户名或者密码错误！");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }  finally {
            }
        }else{

            request.setAttribute("errorMessage","验证码输入错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
