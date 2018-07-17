package com.test;

import java.lang.reflect.Field;
import java.util.HashSet;

import java.util.Set;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Airy on 2018/6/17
 */

public class CollectionTest {

    static class A {
        int a;
        int b;

        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(obj instanceof A){
                try {
                    Boolean check = true;
                    Field[] objectFields = obj.getClass().getDeclaredFields();
                    Field[] PersonFields = obj.getClass().getDeclaredFields();
                    for(int i = 0;i< objectFields.length;i++){
                        if(!objectFields[i].get(obj).equals(PersonFields[i].get(this))){
                            check = false;
                            break;
                        }
                    }
                    return check;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a,b);
        }
    }

    public static void main(String[] args) {

        Set set = new HashSet();

        A a = new A(1,1);
        A b = new A(1,1);

        set.add(a);
        set.add(b);

        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        System.out.println(set);

//        ConcurrentHashMap
    }
}
