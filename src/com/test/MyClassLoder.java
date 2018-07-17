package com.test;

/**
 * Created by Airy on 2018/5/25
 */

public class MyClassLoder extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);

    }
}
