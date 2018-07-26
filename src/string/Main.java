package string;

/**
 * Created by Airy on 2018/7/22
 */

public class Main {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }
    public static void operator(StringBuffer x, StringBuffer y) {
        int a;
//        System.out.println(a);
        x.append(y); y = x;
    }
}
