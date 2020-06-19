
import test1.Key;
import test1.carDealer;
import test1.carManufacturer;

import java.util.HashMap;

public class main {


    public static void main(String[] args){
//        test1
//        Key k1 = new Key("ac12");
//        Key k2=new Key("ac12");
//        System.out.println(k1);
//        System.out.println(k2);
//        HashMap<Key,String> hm=new HashMap<Key, String>();
//        hm.put(k1,"Key with id is 1");
//        System.out.println(hm.get(k2));

//        test2
//        int i=0;
//        int a[]={1,2,3,4};
//        try {
//            System.out.println("Before While");
//            while (i<5){
//                System.out.println(a[i]);
//                i++;
//            }
//            System.out.println("After while");
//        }
//        catch (Exception e){
//            System.out.println("Exception happens");
//            return;
////            System.exit(0);
//        }
//        finally {
//            a=null;
//            System.out.println(a);
//            System.out.println("this is Finally");
//        }

//        test3
        carManufacturer cmf=new carDealer();
        cmf.sellCar();

    }

}
