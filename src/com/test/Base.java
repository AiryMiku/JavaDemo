package com.test;

import javax.swing.plaf.basic.BasicEditorPaneUI;

/**
 * Created by Airy on 2018/6/5
 */

class father {

    static String staticfiled = "1静态变量";

    static {
        System.out.println("1st语句块");
    }

    public String field = "1示例变量";

    {
        System.out.println("1普通语句块");
    }

    public father() {
        System.out.println("1构造");
    }


}

public class Base extends father{

    static String staticfiled = "静态变量";

    static {
        System.out.println("st语句块");
    }

    public String field = "示例变量";

    {
        System.out.println("普通语句块");
    }

    public Base() {
        System.out.println("构造");
    }

    @Override
    public int hashCode() {
        return 1;
    }



    public static void main(String[] args) {
        new Base();
//        System.out.println(new Base().equals(new Base()));
        Integer a = new Integer(123);
        Integer b = Integer.valueOf(123);
        System.out.println(a==b);

        System.out.println(20152015%2016);
    }


}
