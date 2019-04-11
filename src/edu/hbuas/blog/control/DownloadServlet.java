package edu.hbuas.blog.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet",urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String realName="软工培养方案.docx";
        response.setContentType("application/msword");//mime
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(realName,"UTF-8"));

        OutputStream  out=response.getOutputStream();
        FileInputStream in=new FileInputStream(request.getRealPath("files")+"/3s23242sfsfdf23sdfsf.doc");

        byte[] bs=new byte[1024];
        int len=-1;
        while((len=in.read(bs))!=-1){

            out.write(bs,0,len);
        }
        out.flush();
        out.close();
        in.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
