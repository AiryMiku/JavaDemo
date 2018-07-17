package com.test;

/**
 * Created by Airy on 2018/6/5
 */

public class ExceptionTest {

    public static int e(int a) throws Exception {
        try {
            return 10/a;
        }catch (Exception e){
            throw new Exception("aaa");
        } finally {
            System.out.println(111111);
        }
    }

    public static void main(String[] args) {
        try {
            e(0);
        }catch (Exception e){
            System.out.println("1112");
        }
        System.out.println(111);
    }

}
