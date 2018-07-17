package com.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//学校运动会要开始了，你是三年一班的班主任，你们班的开幕式方阵是一个NxN方阵(N是偶数)，
// 临进场之前你突然觉得方阵的阵容有点乱，希望重新排列这个方阵，
// 目标是每个人的前后左右都是异性，也就是女生和男生互相错开。
//
//        例如
//
//        男 女 男 女
//
//        女 男 女 男
//
//        男 女 男 女
//
//        女 男 女 男
//        时间不多，你需要快速重新排列方阵，你决定只做两种调整操作：
//
//        1、横向任意两行，row[i] 与row[j]全部交换位置
//
//        2、纵向任意两列，column[i]与column[j]全部交换位置
//
//        你至少需要做几次调整操作才能达到目标？

class M{
    int ans;
    int[][] mapping;
}

public class SimAlibaba {

    public static int ans = -1;
    Queue<M> queue = new PriorityQueue<>(ansCMP);
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static void solve(int N, int[][] gender,int step) {
        int temp[] = new int[N];
        if(check(N,gender)) {
            if (ans == -1) {
                ans = step;
            }
            if (step < ans) {
                ans = step;
            }
        } else {

            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if(i==j){

                    }
                }
            }


        }

    }



    static boolean check(int N,int [][]map){
        for (int i=1;i<N-1;i++){
            for (int j=1;j<N-1;j++){
                if (map[i][j-1]==map[i][j] || map[i][j+1]==map[i][j] ||  //左右
                        map[i-1][j]==map[i][j] || map[i+1][j]==map[i][j]){ //上下
                    return false;
                }
            }
        }

        return true;
    }

    public static Comparator<M> ansCMP = Comparator.comparingInt(o -> o.ans);

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int gender[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            String l = in.next();
            for (int j = 0; j < n; j++) {
                gender[i][j] = l.charAt(j) == '1' ? 1 : 0;
            }
        }

        solve(n,gender,0);
        System.out.println(String.valueOf(ans));

    }
}