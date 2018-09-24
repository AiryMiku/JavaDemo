package interview.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Airy on 2018/9/9
 */

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        int[] source = new int[]{4,3,2,7,8,2,3,1};
        for (int a : findDisappearedNum(source)) {
            System.out.println(a);
        }
    }

    static int[] findDisappearedNum(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            int idx = (nums[i] < 0) ? -nums[i] - 1 : nums[i] - 1;
            if(nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }

        }

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0) {
                list.add(i + 1);
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size() ; i++)
            ans[i] = list.get(i);

        return ans;



    }

}
