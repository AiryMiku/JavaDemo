package leetcode;

/**
 * Created by Airy on 2018/7/14
 */

public class LongestPalindromicSubstring {

    static public String longestPalindrome(String s) {
        int st=0;
        int en=0;
        for (int i=0;i<s.length();i++){
            int len = Math.max(centerExpand(s,i,i),centerExpand(s,i,i+1));
            if (len > en - st){
                st = i-(len-1)/2; //len - 1 解决偶数的问题
                en = i + len/2;
            }
        }
        System.out.println(s.substring(st,en+1));
        return s.substring(st,en+1);
    }

    /**
     * 中心扩展
     * @param s
     * @param l
     * @param r
     * @return
     */
    static int centerExpand(String s,int l,int r){
        int lf=l;int ri=r;
        while (lf>=0 && ri<s.length() && s.charAt(lf)==s.charAt(ri)){
            lf--;
            ri++;
        }
        return ri-lf-1;
    }

    public static void main(String[] args) {
        longestPalindrome("aba");
    }
}
