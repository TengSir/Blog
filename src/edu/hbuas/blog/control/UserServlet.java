package edu.hbuas.blog.control;

import edu.hbuas.blog.model.dao.UserDAO;
import edu.hbuas.blog.model.dao.UserDAOImp;
import edu.hbuas.blog.model.javabean.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.UUID;

/**
 * 自定义的servlet我们把doget和dopost请求合二为一，然后自己通过请求的方法参数来对不同的业务请求分流到不同的自定义方法中
 */
@MultipartConfig
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
            case "checkUserExist":{
                checkUserExist(request,response);
                break;
            }
            case "checkCode":{
                checkCode(request,response);
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

    protected void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String yourinput=request.getParameter("code");

        String systemCode=request.getSession().getAttribute("code").toString();

        System.out.println(yourinput+"---"+systemCode);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter  out=response.getWriter();

        out.write(yourinput.equalsIgnoreCase(systemCode)+"");

        out.flush();
        out.close();

    } protected void checkUserExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求到后台了");
        String username=request.getParameter("username");
        System.out.println("传过来到用户名"+username);
        boolean result=userDAO.checkUserExists(username);
        System.out.println(result);



        response.setContentType("text/html;charset=utf-8");
        PrintWriter  out=response.getWriter();

        out.write(result+"");
        out.flush();
        out.close();

    }

    /**
     * 这是用户注册的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Part  part=request.getPart("head");
        System.out.println(part.getContentType());//文件类型

        String  uuidName=UUID.randomUUID().toString();
        StringBuffer  childpath=new StringBuffer();
        for(int n=0;n<uuidName.length();n++)
        {
           childpath.append( uuidName.charAt(n)+"/");
        }
         String rootpath= request.getRealPath("upload")+"/"+childpath;
        File path=new File(rootpath);
        path.mkdirs();
        String newFileName=uuidName+"."+part.getContentType().substring(part.getContentType().indexOf("/")+1,part.getContentType().length());

        String fullPath=newFileName;
        FileOutputStream  out=new FileOutputStream(rootpath+newFileName);

        InputStream  in=part.getInputStream();
        byte[] bs=new byte[1024];
        int len=-1;
        while((len=in.read(bs))!=-1){

            out.write(bs,0,len);
        }
        out.flush();
        out.close();
        in.close();



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
        u.setImage("upload/"+childpath+newFileName);
        u.setSex(Long.parseLong(sex));
        u.setAge(Long.parseLong(age));
        try {
          boolean result=userDAO.register(u);

            //3.判断插入语句的执行结果，跳转到页面提示响应的信息
            if(result){
                response.sendRedirect(response.encodeURL("index.jsp"));
            }else{
                request.getRequestDispatcher(response.encodeURL("register.jsp")).forward(request,response);
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
        request.getSession().removeAttribute("user");//销毁session中所有的数据
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


       //当前这个login方法对应的前端请求分两种
        //一种是用户正常登陆，需要填写用户名和密码以及验证码

        if(request.getParameter("username")!=null&&request.getParameter("password")!=null&&request.getParameter("inputCode")!=null){

            //1.先获取上一个页面用户输入的账号信息
            String inputCode= request.getParameter("inputCode");

//            if(inputCode.equalsIgnoreCase(request.getSession().getAttribute("code").toString())){
                String username= request.getParameter("username");
                String password= request.getParameter("password");

                System.out.println(request.getContextPath());
                try {
                    //2.查询数据库中有没有这个账户密码对应的用户信息

                    Users u=userDAO.login(username,password);
                    //3.判断查询结果，如果查到该用户则跳转到首页，没有则跳到登陆页面，提示错误消息

                    if(u!=null){
                        //在登陆成功的分支里判断用户是否要保存用户名和密码到cookie
                        String[]  values=request.getParameterValues("rememberMe");
                        if(values==null){
                            System.out.println("用户不要记住密码");
                        }else{
                            Cookie  usernameCookie=new Cookie("username",username);
                            usernameCookie.setMaxAge(60);
                            response.addCookie(usernameCookie);
                        }

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
//            }else{
//
//                request.setAttribute("errorMessage","验证码输入错误！");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }

        }else{
            //第二种自动登陆（三天免登陆），此时用户没有填写任何用户名和密码以及验证码
            String username=null;
            Cookie[]  cs=request.getCookies();
            for(Cookie c:cs){
                if(c.getName().equals("username")){
                    username=c.getValue();
                    break;
                }
            }
            Users  u=userDAO.login(username);
            request.getSession().setAttribute("user",u);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }
}
