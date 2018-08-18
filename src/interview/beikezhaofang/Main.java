package interview.beikezhaofang;

import java.util.*;

/**
 * Created by Airy on 2018/8/18
 */

public class Main {

    static Scanner in = new Scanner(System.in);

    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean conflict(Node a,Node b){
        if(Math.max(a.start,b.start) <= Math.min(a.end,b.end))
            return true;
        return false;
    }

    public static void main(String[] args) {

        int n;
        n = in.nextInt();
        List<Node> list = new ArrayList<>();
        Set<Integer> ansSet = new HashSet<>();
        for (int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Node node = new Node(a,b);
            list.add(node);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(conflict(list.get(i),list.get(j))){
                    ansSet.add(i);
                    ansSet.add(j);
                }
            }
        }

        System.out.println(ansSet.size());

    }

}
