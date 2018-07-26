package swordoffer;

import org.w3c.dom.css.Rect;

import java.util.Stack;

/**
 * Created by Airy on 2018/7/17
 */
class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        int ans = stack2.pop();
        while (!stack2.isEmpty()){
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        return ans;
    }

}
public class StackToQueue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
//        System.out.println(solution.pop());
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
    }
}
