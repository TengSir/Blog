package edu.hbuas.blog.util;

import edu.hbuas.blog.model.javabean.Users;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONDemo {
    public static void main(String[] args) throws Exception {
        Users  use=new Users();
        use.setAge(12);
        use.setNickname("jack");
        use.setSex(1);

        JSONObject  obj=new JSONObject();

        obj.put("nickname",use.getNickname());
        obj.put("age",use.getAge());
        obj.put("sex",use.getSex());

        System.out.println(obj.toString());

        JSONArray objs=new JSONArray();
        objs.put(obj);
        objs.put(obj);
        objs.put(obj);
        objs.put(obj);
        System.out.println(objs.toString());

    }
}
