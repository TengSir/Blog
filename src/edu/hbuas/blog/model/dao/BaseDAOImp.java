package edu.hbuas.blog.model.dao;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
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
          Context  c= null;
          try {
              c = new InitialContext();
              dataSource=(DataSource)c.lookup("java:comp/evn/jdbc/blog");

          } catch (NamingException e) {
              e.printStackTrace();
          }


          //链接池的代码
          /**
           *  Properties  properties=new Properties();
           *           try {
           *               properties.load(new FileInputStream("main/resources/jdbc.properties"));
           *           } catch (IOException e) {
           *               e.printStackTrace();
           *           }
           *           dataSourceFactory=new BasicDataSourceFactory();//链接池工厂
           *           try {
           *               dataSource=dataSourceFactory.createDataSource(properties);
           *           } catch (Exception e) {
           *               e.printStackTrace();
           *           }
           */
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


}
