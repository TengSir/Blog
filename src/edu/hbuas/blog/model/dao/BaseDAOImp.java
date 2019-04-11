package edu.hbuas.blog.model.dao;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BaseDAOImp implements BaseDAO {

    private Connection  con;
    private PreparedStatement pre;
    private Statement sta;
    private static BasicDataSourceFactory  dataSourceFactory;
    private static DataSource dataSource;

      static{
          //jndi的代码
         /*   Context  c= null;
                    try {
                           c = new InitialContext();
                          dataSource=(DataSource)c.lookup("java:comp/env/jdbc/blog");

                     } catch (NamingException e) {
                         e.printStackTrace();
                      }*/
          //链接池的代码
          File proFile=new File("/Users/tengsir/workspace/java/idea/Blog/src/main/resources/jdbc.properties");
          File  f=new File(".");
          System.out.println(f.getAbsoluteFile());
          System.out.println(proFile.getAbsoluteFile());
          FileInputStream in= null;
          try {
              in = new FileInputStream(proFile);
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          Properties  properties=new Properties();
          try {
              properties.load(in);
          } catch (IOException e) {
              e.printStackTrace();
          }
          for(Object key:properties.keySet()){
              System.out.println(key+"="+properties.get(key));
          }
          dataSourceFactory=new BasicDataSourceFactory();//链接池工厂
          try {
              dataSource=dataSourceFactory.createDataSource(properties);
          } catch (Exception e) {
              e.printStackTrace();
          }

      }


    public Statement getSta() {
        if(con==null)
        {
            con=getCon();
        }
        try {
            sta=con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sta;
    }


    public Connection getCon() {

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PreparedStatement getPre(String sql) {
        if(con==null)
        {
            con=getCon();
        }
        try {
            pre=con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pre;
    }
    public void disposeResource(Connection con, Statement sta,PreparedStatement pre,ResultSet rs){

    }

    public static void main(String[] args) {
        System.out.println("test");
    }


}
