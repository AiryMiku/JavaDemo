package interview.bytedance;


import java.util.Scanner;

/**
 * Created by Airy on 2018/9/9
 */

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int people[] = new int[n+1];
        int follow[] = new int[n+1];
        for (int i=1;i<=n;i++) people[i] = i;
        for(int i=0;i<m;i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            unite(people,y,x,follow);
        }
        int ans = 0;
        for (int i=1;i<=n;i++) {
            System.out.println("people "+people[i]);
            System.out.println("follow "+follow[i]);
            if(people[i] == i){
                ans++;
            }
        }
        System.out.println(ans);

    }
    static int find(int people[],int x,int follow[]) {
        follow[x]++;
        if (people[x] == x) return x;
        else {
            return find(people,people[x],follow);
        }

    }

    static boolean unite(int people[],int x, int y,int follow[])
    {
        int fx = find(people, x,follow);
        int fy = find(people, y,follow);
        if (fx != fy)
        {
            people[fy] = fx;
            return true;
        }
        else
        {
            return false;
        }
    }


}
