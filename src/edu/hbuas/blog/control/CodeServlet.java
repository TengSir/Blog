package edu.hbuas.blog.control;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(name = "CodeServlet",urlPatterns = "/CodeServlet")
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=120,height=40;
        int startX=5,y=30;
        String[]  fontNames={"华文行楷","宋体","楷体","黑体"};

        BufferedImage image=new BufferedImage(width,height, Image.SCALE_DEFAULT);



        Graphics  g=image.getGraphics();//从当前图像上获取一个画笔对象，该画笔只能在该图像上画东西

        g.setColor(Color.white);
        g.fillRect(0,0,width,height);



        //生成干扰线
        for(int n=0;n<200;n++){
            g.setColor(new Color(((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256));

            g.fillOval(((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height,2,2);
            //g.drawLine(((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height,((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height);
            //g.drawLine(((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height,((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height);
        }

        for(int n=0;n<10;n++){
            g.setColor(new Color(((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256));
            g.drawLine(((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height,((int)(Math.random()*1000000))%width,((int)(Math.random()*1000000))%height);
        }


        StringBuffer sb=new StringBuffer();
        //生成验证码字母

        for(int n=0;n<6;n++){
            g.setColor(new Color(((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256));

            int fontsize=((int)(Math.random()*1000000))%20+10;

            g.setFont(new Font(fontNames[((int)(Math.random()*1000000))%fontNames.length],(((int)(Math.random()*10))%2==0)?Font.BOLD:Font.ITALIC,fontsize));

            char cc=(char)(((int)(Math.random()*1000000))%26+65);

            g.drawString(cc+"",startX,y);

            startX+=fontsize-4;
            sb.append(cc);


        }
        System.out.println("生成的验证吗是："+sb);

        request.getSession().setAttribute("code",sb.toString());//将上面生成的验证码字符串存储到session里



        //使用servletapi中的response对象中的方法来设置响应格式以及输出内容;
        response.setContentType("image/jpg");//设置响应的内容格式（通知浏览器这个servlet给你发过去的是什么内容）

        ImageIO.write(image,"jpg",response.getOutputStream());//将图像使用servle的输出流输出到客户端到浏览器上



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
