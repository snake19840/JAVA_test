package com.redis;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestSerializerTranscoder implements Serializable {
    private static final long serialVersionUID = 1L;
    public TestSerializerTranscoder() {

    }
    public static List<TestUser> list(){
        int a=2;
        List<TestUser> list=new ArrayList<TestUser>();
        for (int i = 0; i < 2; i++) {
            TestUser testUser=new TestUser();
            testUser.setName("张"+Integer.toString(i));
            testUser.setAge(i+30);
            if (i%2==0){
                testUser.setSex(false);
            }else {
                testUser.setSex(true);
            }
            list.add(testUser);
        }
        return list;
    }



    @Test
    public void testObject() {

        List<TestUser> lists = TestSerializerTranscoder.list();

        TestUser userA = lists.get(1);

        ObjectsTranscoder<TestUser> objTranscoder =  new ObjectsTranscoder<TestUser>();

        byte[] result1 = objTranscoder.serialize(userA);

        TestUser userA_userA = objTranscoder.deserialize(result1);

        System.out.println(userA_userA.getName() + "\t" + userA_userA.getAge());
    }


    public static void main(String[] args) {
        TestSerializerTranscoder testSerializerTranscoder=new TestSerializerTranscoder();
        testSerializerTranscoder.testObject();
    }

}
