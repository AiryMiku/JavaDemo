package leetcode;


/**
 * Created by Airy on 2018/6/8
 */

public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(reverse(-123));
    }

    static public int reverse(int x) {
        try{
            boolean bit = x < 0 ? true:false;
            System.out.println(String.valueOf(x));
            String a = "123";

            StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
            sb.reverse();
            if (bit) {
                String r = "-"+sb.toString();
                return Integer.valueOf(r);
            } else {
                return Integer.valueOf(sb.toString());
            }
        }catch (NumberFormatException e){
            return 0;
        }

    }

}
