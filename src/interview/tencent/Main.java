package interview.tencent;

import java.util.Scanner;

/**
 * Created by Airy on 2018/9/16
 */

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        long array[] = new long[106];
        int nut = 0;
        int n = in.nextInt();

        for (int i=1;i<=n;i++){
            array[i] = in.nextInt();
            if (array[i] == 1){
                nut++;
            }
        }

        if (nut == 0 || nut == 1) {
            System.out.println(nut);
        } else {
            int k;
            for (k=1;k<=n;k++){
                if (array[k] == 1)
                    break;
            }
            long ans=1;
            int temp=0;
            for (int i=k;i<=n;i++){
                if (array[i] == 1){
                    if (temp!=0)
                        ans*=(1+temp);
                    temp=0;
                }else{
                    temp++;
                }

            }
            System.out.println(ans);

        }

    }



}
