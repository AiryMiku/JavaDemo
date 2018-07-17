package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Airy on 2018/7/15
 */



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doS(list,root);
        return list;
    }
    public void doS(List<Integer> list,TreeNode r){
        if(r == null){
            return;
        }else{
            doS(list,r.left);
            list.add(r.val);
            System.out.println(r.val);
            doS(list,r.right);
        }
    }

}
