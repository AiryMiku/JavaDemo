package interview.yy;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Airy on 2018/9/14
 */

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int a = in.nextInt();
        int b = in.nextInt();
        int sm;
        BigInteger mm;
        for (int i=a;i<=b;i++){
            sm = 0;
            mm = BigInteger.ONE;
            for (int j=1;j<=(i/2);j++){
                if(i%j == 0){
                    sm += j;
//                    System.out.println(sm);
                    mm = mm.multiply(new BigInteger(String.valueOf(j)));
//                    System.out.println(mm);
                }
            }
            if(sm == 100 && mm.equals(new BigInteger(String.valueOf(i)))){
                System.out.println(i);
                return;
            }

        }


    }


}
