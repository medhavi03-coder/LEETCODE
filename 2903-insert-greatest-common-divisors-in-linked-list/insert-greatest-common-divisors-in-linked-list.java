/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
int GCD(int a, int b){
    while(b != 0){
        int temp = b;
        b = a%b;
        a = temp;
    }
    return a;
}
public ListNode insertGreatestCommonDivisors(ListNode head) {
    if(head == null || head.next == null)return head;
ListNode temp = head;
while(temp.next != null){
    ListNode cur = temp;
    ListNode next = temp.next;
    int gcd = GCD(cur.val, next.val);
    ListNode newNode = new ListNode(gcd);
    cur.next = newNode;
    newNode.next = next;
    temp = next;
}
return head;
    }
}