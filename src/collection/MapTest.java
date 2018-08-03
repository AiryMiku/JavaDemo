package collection;

import java.util.HashMap;

/**
 * Created by Airy on 2018/7/27
 */

public class MapTest {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(3));
    }
}
