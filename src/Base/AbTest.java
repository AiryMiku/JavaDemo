package Base;

/**
 * Created by Airy on 2018/7/16
 */
abstract class ABClass{

    int a = 1;

    ABClass(){
        System.out.println("hello");
        //抽象方法可以有构造函数
    }

    void doSome(){
        System.out.println("do");
        //也可以有非抽象方法
    }

}

public class AbTest extends ABClass{

    @Override
    void doSome() {
        super.doSome();
        System.out.println(super.a);
    }
}
