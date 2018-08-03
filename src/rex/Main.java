package rex;

import java.util.regex.Pattern;

/**
 * Created by Airy on 2018/7/29
 */

public class Main {
    private static String sizePattern = "\\S* \\S*";
    private static String connectPattern = "^(-?\\S+\\,-?\\S+-?\\s-?\\S+\\,-?\\S+;)*(-?\\S+\\,-?\\S+-?\\s-?\\S+\\,-?\\S+)$";

    public static void main(String[] args) {
        String size = "3 3";
        boolean isMatch = Pattern.matches(sizePattern,size);
        System.out.println(isMatch);
        String conn = "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
        isMatch = Pattern.matches(connectPattern,conn);
        System.out.println(isMatch);

        System.out.println(Integer.valueOf("jdfhjd"));
    }

}
