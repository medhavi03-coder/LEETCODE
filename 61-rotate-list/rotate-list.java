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
    
    public ListNode rotateRight(ListNode head, int k) {
      
    while(head == null ||head.next == null ||  k == 0)
    {return head;}
        int len = 1;
          ListNode temp = head; 
          while(temp.next != null){
            len++;
            temp = temp.next;
          }
          k =k%len;
          if(k == 0)return head;
          temp.next = head;

          temp = head;
          int n = len -k;
          for(int i =1; i<n;i++){
            temp = temp.next;
          }
          head = temp.next;
          temp.next= null;
    return head;
    }    
    }
