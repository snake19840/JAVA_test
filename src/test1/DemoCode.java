package test1;

import java.io.IOError;
import java.io.IOException;

class BaseClass{
    public void func() throws IOException{
        try {
            System.out.println("In Base");
        }catch (IOError error){
            throw error;
        }

    }
}
class ChildClass extends BaseClass  {
    //override
    public void func()  {
        System.out.println("In Child");
    }
}

public class DemoCode {
    public static void main(String[] args) throws IOException {
        ChildClass child = new ChildClass();
        child.func(); //In Child
        BaseClass baseClass=new BaseClass();
        baseClass.func();
    }

}
