package com.test;


import java.util.*;


class Cow {
    int age;
    int kid;

    Cow(int age){
        this.age = age;
    }

    Cow birth(){
        if(age>=5){
            return new Cow(1);
        }
        return null;
    }
}

abstract class A{
    int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class Main {

    public static List<Cow> cows;

    public static void main(String[] args){

        cows = new ArrayList<>();
        cows.add(new Cow(5)); // 有一牛

        for (int i=1;i<=20;i++){
            List<Cow> tmp = new ArrayList<>(); //待产牛

            for(Cow cow:cows){ // 遍历原牛
                tmp.add(cow); // +原来的牛
                cow.age += 1; // 长大
                Cow littleCow = cow.birth(); // 产牛
                if(littleCow!=null){
                    tmp.add(littleCow);
                }
            }

            cows = tmp; //总牛
            tmp = null; // 清空
        }

        System.out.println(cows.size());


        String a ="hh";
        String b ="hh";
        char[] chars = {'h','h'};

        Integer aaa = 1;
        Integer bbb = new Integer(1);
        Integer ccc = 2;


        System.out.println(ccc == (aaa+bbb));


    }
}