package com.oracle;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrcSel {
    public static List<Equ> selAll(String sql) {
           List<Equ> list = new ArrayList<Equ>();

   try {
           int inti = 1;
           Connection conn = JDBCconnect.getConnection();
                 conn.setAutoCommit(true);

              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
             ResultSetMetaData md = rs.getMetaData();
             int columnCount = md.getColumnCount();
              while (rs.next()) {
                  Equ equ = new Equ();

                   Map<String, Object> rowData = new HashMap<String, Object>();
                    for (int i = 1; i <= columnCount; i++) {
                        rowData.put(md.getColumnName(i), rs.getObject(i));
                  }
                   equ.setRowData(rowData);
                    list.add(equ);
                   }

       JDBCconnect.close(conn,ps,rs);
               } catch (Exception e) {

                  e.printStackTrace();
              }
           return list;
          }

    public static void main(String[] args) {
        String sql="SELECT * FROM dxtest";
        List<Equ> list=OrcSel.selAll(sql);
        Gson gson=new Gson();
        String listgson=gson.toJson(list);
        System.out.println(listgson);
    }
}
