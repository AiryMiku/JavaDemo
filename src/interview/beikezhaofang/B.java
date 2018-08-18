package interview.beikezhaofang;

import java.util.Scanner;

/**
 * Created by Airy on 2018/8/18
 */

public class B {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int a = in.nextInt();
            min = Math.min(min,a);
            sum+=a;
        }

        if(n==1){
            System.out.println(sum);
        }else{
            System.out.println(sum-min);
        }
    }
}
