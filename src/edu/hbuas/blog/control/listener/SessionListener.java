package edu.hbuas.blog.control.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听新用户访问，和用户离开的监听器
 */
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("来了一个新用户，这个用户的sessionId："+httpSessionEvent.getSession().getId());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("走了一个用户，这个用户的sessionId："+httpSessionEvent.getSession().getId());
    }
}
