package 两数相加;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            ListNode currentNode = new ListNode(sum % 10);
            root.next = currentNode;
            root = currentNode;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        return root.next;
    }

}
class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
