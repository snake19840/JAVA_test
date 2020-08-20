package com.redis;


import com.oracle.Equ;
import com.oracle.OrcSel;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.*;

public class RedisJava {

     final static Jedis jedis=RedisJava.getJedis("127.0.0.1","test");

  private    static Jedis getJedis(String host) {
         Jedis jedis=new Jedis(host);
      return jedis;
    }

    private    static Jedis getJedis(String host ,int port) {
        Jedis jedis=new Jedis(host,port);
        return jedis;
    }
    private    static Jedis getJedis(String host ,int port ,String pass) {
        Jedis jedis=new Jedis(host,port);
        jedis.auth(pass);
        return jedis;
    }
    private    static Jedis getJedis(String host  ,String pass) {
        Jedis jedis=new Jedis(host);
        jedis.auth(pass);
        return jedis;
    }

    public void test1() {

        ArrayList<String> aList = new ArrayList<String>();
        aList.add("bbc");
        aList.add("abc");
        aList.add("ysc");
        aList.add("saa");
        System.out.println("移除前：" + aList);
        ListIterator<String> listIt = aList.listIterator();
        while (listIt.hasNext()) {
            if ("abc".equals(listIt.next())) {
                listIt.remove();
            }
        }
        System.out.println("移除后：" + aList);
    }

    public void addstr() {
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
    }

    public void addlist() {
        //存储数据到列表中

        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    public void getstr() {
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key);
        }
    }
    public static String getType(Object test) {
        return test.getClass().getName().toString();

    }
public static String toNull(BigDecimal a){
     String b;
    if (getType(a).equals("java.lang.String")){
        b= a==null? "":a.toString();
    }else {
        b= a==null? "":a.toString();
    }

return b;

}

    public static String toNull (String a){

        a= a==null? "":a;
        return a;
    }


    public static void main (String[]args) throws Exception {

        RedisJava redisJava=new RedisJava();
                String sql="SELECT * FROM dxtest";
        List<Equ> list= OrcSel.selAll(sql);
        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(getType(list.get(i).getRowData().get("REDATE")));
//            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString(), redisJava.toNull((BigDecimal) list.get(i).getRowData().get("ID")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":STDATE",  redisJava.toNull( (String) list.get(i).getRowData().get("STDATE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SDATE",  redisJava.toNull( (String) list.get(i).getRowData().get("SDATE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":EDATE",  redisJava.toNull( (String) list.get(i).getRowData().get("EDATE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":REDATE",  redisJava.toNull( (String) list.get(i).getRowData().get("REDATE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":PNAME",  redisJava.toNull( (String) list.get(i).getRowData().get("PNAME")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":USE",  redisJava.toNull( (String) list.get(i).getRowData().get("USE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":OWNNAME",  redisJava.toNull( (String) list.get(i).getRowData().get("OWNNAME")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":PRONAME",  redisJava.toNull( (String) list.get(i).getRowData().get("PRONAME")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":MANNAME",  redisJava.toNull( (String) list.get(i).getRowData().get("MANNAME")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":AGENAME",  redisJava.toNull( (String) list.get(i).getRowData().get("AGENAME")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":MANTYP",  redisJava.toNull( (String) list.get(i).getRowData().get("MANTYP")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SNAME",  redisJava.toNull( (String) list.get(i).getRowData().get("SNAME")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":STYP",  redisJava.toNull( (String) list.get(i).getRowData().get("STYP")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":POS",  redisJava.toNull( (String) list.get(i).getRowData().get("POS")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":IP",  redisJava.toNull( (String) list.get(i).getRowData().get("IP")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":PORT",  redisJava.toNull( (String) list.get(i).getRowData().get("PORT")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":CPU",  redisJava.toNull( (String) list.get(i).getRowData().get("CPU")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":MEMORY",  redisJava.toNull( (String) list.get(i).getRowData().get("MEMORY")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":DISK",  redisJava.toNull( (String) list.get(i).getRowData().get("DISK")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SYN",  redisJava.toNull( (String) list.get(i).getRowData().get("SYN")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":ORACLE",  redisJava.toNull( (String) list.get(i).getRowData().get("ORACLE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SN",  redisJava.toNull( (String) list.get(i).getRowData().get("SN")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":OTH",  redisJava.toNull( (String) list.get(i).getRowData().get("OTH")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SROOT",  redisJava.toNull( (String) list.get(i).getRowData().get("SROOT")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SPWD",  redisJava.toNull( (String) list.get(i).getRowData().get("SPWD")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":OROOT",  redisJava.toNull( (String) list.get(i).getRowData().get("OROOT")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":OPWD",  redisJava.toNull( (String) list.get(i).getRowData().get("OPWD")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":AROOT",  redisJava.toNull( (String) list.get(i).getRowData().get("AROOT")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":APWD",  redisJava.toNull( (String) list.get(i).getRowData().get("APWD")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":TITLE",  redisJava.toNull( (String) list.get(i).getRowData().get("TITLE")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":URL",  redisJava.toNull( (String) list.get(i).getRowData().get("URL")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":SID",  redisJava.toNull( (String) list.get(i).getRowData().get("SID")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":DID",  redisJava.toNull( (String) list.get(i).getRowData().get("DID")));
            redisJava.jedis.set("dxtest:ID:"+list.get(i).getRowData().get("ID").toString()+":STATU",  redisJava.toNull( (String) list.get(i).getRowData().get("STATU")));

        }


        Set s=redisJava.jedis.keys("dxtest:PNAME:*");
        Iterator it=s.iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            String value = redisJava.jedis.get(key);
            System.out.println(key +"   " +value);
        }
//        for (int i = 0; i < 10; i++) {
//            redisJava.jedis.set("test1:name:"+i, String.valueOf(i));
//        }

    }



//    public static void main (String[]args) throws Exception {
//        RedisJava redisJava=new RedisJava();
//        String sql="SELECT * FROM dxtest";
//        List<Equ> list= OrcSel.selAll(sql);
//        for (int i = 0; i < list.size(); i++) {
//          Equ obj= list.get(i);
//            ObjectsTranscoder<Equ> objTranscoder =  new ObjectsTranscoder<Equ>();
//            StringTranscoder stringTranscoder=new StringTranscoder();
//            byte[] byte_rowData = objTranscoder.serialize(obj);
//            byte[] byte_table = stringTranscoder.strserialize("dxtest");
//            jedis.sadd(byte_table,byte_rowData);
//        }
//        StringTranscoder stringTranscoder=new StringTranscoder();
//        byte[] bb= stringTranscoder.strserialize("dxtest");
//
//        Set<byte[]> a = jedis.smembers(bb);
//        ObjectsTranscoder<Equ> objTranscoder =  new ObjectsTranscoder<Equ>();
//
//            Equ aObj=objTranscoder.deserialize((byte[]) a.toArray()[0])  ;
//        Gson gson=new Gson();
//        String aa=gson.toJson(aObj);
//
//        System.out.println(11);

//    }


//    public static void main(String[] args) {
//        RedisJava redisJava=new RedisJava();
//        redisJava.jedis.sadd("testsadd","你");
//        redisJava.jedis.sadd("testsadd","我");
//        redisJava.jedis.smembers("testsadd");
//
//        System.out.println(redisJava.jedis.smembers("testsadd"));
//    }

}

