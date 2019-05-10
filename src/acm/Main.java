package acm;

import java.util.Scanner;

/**
 * Created by Airy on 2018/7/21
 */

public class Main {
    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        int[] price = new int[100005];
        int[][] dp = new int[2][100005];
        int T = in.nextInt();
        for (int i=0;i<T;i++){
            int profit = 0;
            int time = 0;
            int n=in.nextInt();
            for (int j=0;j<n;j++){
                price[j]= in.nextInt();
            }
            dp[0][0] = 0;
            for (int k=1;k<n;k++){
                
                dp[0][k] = Math.max(dp[0][k],dp[0][k-1]);
                if(price[k] > price[k-1]){
                    dp[0][k] = price[k] - price[k-1];
                }

            }

        }

    }

}
