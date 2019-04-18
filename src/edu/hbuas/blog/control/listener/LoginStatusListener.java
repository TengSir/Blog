package edu.hbuas.blog.control.listener;

import edu.hbuas.blog.model.javabean.Users;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Enumeration;

@WebListener
public class LoginStatusListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //System.out.println("当前又一个人登陆了，登陆的账户信息如下：----------------"+httpSessionBindingEvent.getName()+"\t"+httpSessionBindingEvent.getValue());;

//        if(httpSessionBindingEvent.getSession().getServletContext().getAttribute(((Users)httpSessionBindingEvent.getValue()).getUserid()+"")!=null){
//            httpSessionBindingEvent.getSession().removeAttribute(httpSessionBindingEvent.getName());
//            System.out.println("当前这个账号已经登陆，此时不能再次登陆，删除这个新的账户的session里面登陆用户信息，同时跳转到登陆页面");
//
//        }else{
//            httpSessionBindingEvent.getSession().getServletContext().setAttribute(((Users)httpSessionBindingEvent.getValue()).getUserid()+"",httpSessionBindingEvent.getValue());
//        }

        //        System.out.println("当前登陆的所有用户信息如下:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        Enumeration<String> keys= httpSessionBindingEvent.getSession().getServletContext().getAttributeNames();
//        while(keys.hasMoreElements())    {
//            String key=keys.nextElement();
//            System.out.println(key+":"+ httpSessionBindingEvent.getSession().getServletContext().getAttribute(key));
//
//        }
//        System.out.println("\n\n\n\n\n\n");


    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("---------用户从session中移除了某一个属性");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("替换了session里面某一个值");
    }
}
