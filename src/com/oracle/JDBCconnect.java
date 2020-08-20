package com.oracle;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCconnect {

    public static String getOracle(String propertyName)  {
        String a="";
        Properties pro = new Properties();
        try {
            pro.load(new BufferedInputStream(new FileInputStream("config.ini")));
//            for (String key : pro.stringPropertyNames()){
//
//            }
             a = pro.getProperty(propertyName);

        }catch (FileNotFoundException  f){
            f.printStackTrace();
        }catch (IOException i){
            i.printStackTrace();
        }
        return a;
    }

 public static   Connection getConnection(){
     Connection conn = null;
     try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn= DriverManager.getConnection("jdbc:oracle:thin:@"+ JDBCconnect.getOracle("host")+":"+
                 JDBCconnect.getOracle("port")+":"+ JDBCconnect.getOracle("sid")+"",
                 JDBCconnect.getOracle("user"), JDBCconnect.getOracle("pass"));
     }catch (ClassNotFoundException e){
         e.printStackTrace();
     }catch (SQLException e){
         e.printStackTrace();
     }
     return conn;
 }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub

        //关闭结果集
        try {
            //结果集关闭方法
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭声明的sql语句
            try {
                //关闭声明的sql语句方法
                if(ps!=null){
                    ps.close();
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                //卸载驱动
                try {
                    //驱动卸载方法
                    if(con!=null){
                        con.close();
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

    }





    public static void main(String[] args) {
        JDBCconnect jdbCconnect=new JDBCconnect();



    }


}
