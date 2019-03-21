package edu.hbuas.blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateImage {

    public static void main(String[] args) {
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


        //生成验证码字母

        for(int n=0;n<6;n++){
            g.setColor(new Color(((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256,((int)(Math.random()*1000000))%256));

            int fontsize=((int)(Math.random()*1000000))%20+10;

            g.setFont(new Font(fontNames[((int)(Math.random()*1000000))%fontNames.length],(((int)(Math.random()*10))%2==0)?Font.BOLD:Font.ITALIC,fontsize));

            char cc=(char)(((int)(Math.random()*1000000))%27+65);

            g.drawString(cc+"",startX,y);

            startX+=fontsize-4;
        }


        try {
            ImageIO.write(image,"jpg",new FileOutputStream("/Users/TengSir/1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
