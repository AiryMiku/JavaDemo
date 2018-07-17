package com.test;

/**
 * Created by Airy on 2018/7/16
 */
class Car extends Vehicle
{
    public static void main (String[] args)
    {
        new  Car().run();
        // print Car
    }

    /**
     * 因为父类的run不可见，所以子类的run和它并不是一个东西
     * 如果父类为非private，那么有了final肯定不能覆盖
     */
    private final void run()
    {
        System. out. println ("Car");
    }
}
class Vehicle
{
    private final void run()
    {
        System. out. println("Vehicle");
    }
}
public class ReloadTest {

}
