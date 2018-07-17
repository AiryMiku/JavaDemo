package leetcode;

/**
 * Created by Airy on 2018/6/22
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4).
                next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(6).
                next = new ListNode(4);

        addTwoNumbers(l1,l2);
    }

    private static ListNode fuck(ListNode l1, ListNode l2, int bit){
        if(l1 == null && l2 == null && bit == 0) {
            return null;
        }
        int sum = 0;
        if(l1 != null) sum += l1.val;
        if(l2 != null) sum += l2.val;
        ListNode node = new ListNode((sum+bit) % 10);
        System.out.println((sum+bit) % 10);
        node.next = fuck(l1 == null ? null : l1.next, l2 == null ? null :l2.next,(sum+bit)/10);
        return node;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return fuck(l1,l2,0);
    }
}
