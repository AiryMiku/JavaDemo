import java.util.*;
import java.util.concurrent.BlockingDeque;

/**
 * Created by Airy on 2018/7/6
 */
class item implements Comparable<item>{
    int v;
    int w;

    @Override
    public int compareTo(item o) {
        if(this.w > o.w)
            return 0;
        else
            return -1;
    }
}
public class Main {
    static int cnt = 6;
    static{
        cnt += 9;
    }
    static{
        cnt /=3;
    }
    public static void main(String[] args) {
        int a[] = {1,3,2};
        Arrays.sort(a);
        for (int i:a){
            System.out.println(i);
        }
        Map<Integer,Integer> vis = new HashMap<>();
        vis.put(1,123);
        vis.put(2,234);
        for (Integer i : vis.values()){
            System.out.println(i);
        }
        String rrr = "123";
        rrr.toCharArray();

        String source[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(source);
        char aaaaaa ='1';
        Character aaa = aaaaaa;
        Integer i1=100;
        Integer i2=100;

        System.out.println(i1==i2);

        System.out.println(cnt);
//        dow();


    }


    public void dow(){}
    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<List<Character>,List<String>> vis = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            List<Character> listChar = new ArrayList<>();
            for (int k=0;k<tmp.length;k++){
                listChar.add(tmp[k]);
            }
            if(!vis.containsKey(listChar)){
                List<String> inner = new ArrayList<>();
                inner.add(strs[i]);
                vis.put(listChar,inner);
            } else {
                vis.get(listChar).add(strs[i]);
            }

        }
        for(List<String> v : vis.values()){
            ans.add(v);
        }
        return ans;
    }
}
