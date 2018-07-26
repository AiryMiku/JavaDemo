package nowcoder;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Airy on 2018/6/16
 */

public class Main {

    public static int ans = 0;
    static int n = 6;
    static int[] x = new int[10];
    private static int pInt = 1;
    static class Inner{
        public void doS(){
            queen(1);
            System.out.println(ans);
        }
    }

//    Main(){
//        this();
//    }
    public static void main(String[] args) {
//        int a[] = null;
//        a[0] = 1;
//        int i = Integer.parseInt("123a");
//        System.out.println(i);
        queen(1);
        System.out.println(ans);
        float []floats[] = new float[6][];
        String str = "12";
        String s = "12";
        char c[] = {'1','2'};
        System.out.println(str.equals(c));
        change(str);
        System.out.println(str);
        List list = new ArrayList();
        list.add(0);
        System.out.println(list.get(0) instanceof Integer);
        String s1;
//        System.out.println(s1); not init
        // 按指定模式在字符串查找
        String line = "北京市(海淀区)(朝阳区)(西城区)";
        String pattern = ".*?(?=\\()";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println(m.group());
        } else {
            System.out.println("NO MATCH");
        }
        System.out.println("1"+2+3);
        System.out.println(1+2+"3");
        System.out.println(s.substring(0,1));

//        if(1=1){
//          complier error
//        }
        Main main = new Main();
        System.out.println(main.ans+"---");

//        a = Integer.parseInt("1024");  返回int基本类型

//        b = Integer.valueOf("1024").intValue();  valueOf返回new Integer,如果数字在常量池缓存（-128-127）从常量池取，否则new
//        intValue返回integer对象的int值

        int i=5;

        int is=(i++)+(++i)+(i--)+(--i);

        System.out.println(is);
        int x = 20, y = 5;
        System.out.println(x+y+""+(x+y)+y);
        System.out.println(2.5/2.5);
        try{
            
        }finally {

        }
    }

    static void change(String str) {
        str = "123";
    }

    static boolean place(int k){
        for (int j = 1; j < k; ++j)
            if (x[j] == x[k])
                return false;
        return true;
    }
    public static void queen(int k){

        if (k>4) {
            ans++;
        } else {
            for (int i=0;i<n;i++) {
                x[k] = i;
                if (place(k)){
                    queen(k+1);
                }
            }
        }

    }

    static void sleep(){

    }

}
