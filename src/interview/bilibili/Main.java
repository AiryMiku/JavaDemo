package interview.bilibili;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Airy on 2018/9/7
 */

class Machs implements Comparable<Machs>{
    int num;
    int wood;

    public Machs(int num, int wood) {
        this.num = num;
        this.wood = wood;
    }

    @Override
    public int compareTo(Machs o) {
        return (o.num/o.wood)-(this.num/this.wood)  ;
    }

    @Override
    public String toString() {
        return "Machs{" +
                "num=" + num +
                ", wood=" + wood +
                '}';
    }
}

public class Main {

    public static Scanner in = new Scanner(System.in);
    static List<Machs> machsList = new ArrayList<>();
    static BigInteger ans = BigInteger.ZERO;
    public static void main(String[] args) {
        machsList.add(new Machs(0,6));
        machsList.add(new Machs(1,2));
        machsList.add(new Machs(2,5));
        machsList.add(new Machs(3,5));
        machsList.add(new Machs(4,4));
        machsList.add(new Machs(5,5));
        machsList.add(new Machs(6,6));
        machsList.add(new Machs(7,3));
        machsList.add(new Machs(8,7));
        machsList.add(new Machs(9,6));
        Collections.sort(machsList);


    }

//    static String maxNum(int m,int n) {
//        backTrace(null,0,m,n,ans);
//        System.out.println(ans);
//    }

    static void backTrace(BigInteger cur,int k,int m,int n,BigInteger ans) {
        if (k == n) {
            ans = cur.max(ans);
        }
        if(k < n){
            if(cur==null) {
                for (Machs machs : machsList) {
                    if(m >= machs.wood) {
                        backTrace(BigInteger.valueOf(machs.num),k+1,m-machs.wood,n,ans);
                    }
                }
            }
            if (cur != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(cur.toString());
                for (Machs machs : machsList) {
                    if(m >= machs.wood) {
                        sb.append(machs.num);
                        BigInteger bigInteger = new BigInteger(sb.toString());
                        backTrace(bigInteger,k+1,m-machs.wood,n,ans);
                    }
                }
            }

        }

    }

}
