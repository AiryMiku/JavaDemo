package Base;


import javax.sound.midi.Soundbank;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Airy on 2018/6/20
 */

class A extends Thread{
    @Override
    public void run() {
        while (true){}
    }

    public void test(){
        System.out.println(super.getClass().getName());
    }
}
interface iC{

}

interface iC1{

}
interface iC2 extends iC,iC1{

}
public class Main implements iC{
    static int s_a = 1;

    Main(int a){
        inc();
    }
    public static void main(String[] args) {

        String str = "abc";
        str.toUpperCase();
        System.out.println(str);
        System.out.println(str.toUpperCase());
        System.out.println(str=="abc");
        System.out.println("abc" =="abc");
        System.out.println(10 % 3 * 2);

//        Thread thread = new A();
//        ((A) thread).test();

        int arr[] = new int[5];
        int a = 0;
        System.out.println(a);
        inc();
        System.out.println(s_a);
        System.out.println(1+"10"+3+"2");
        new Main(1);
        short sh = 128;
        byte b = (byte)sh;
        System.out.println(b);
//        NullPointerException
    }

    static int inc(){
        return s_a++;
    }
}
