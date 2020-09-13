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
    static ListNode TH=null;
    static ListNode TT=null;
   
    public ListNode reverseKGroup(ListNode head, int k) {
          if(head==null ||head.next==null || k<=1){
              return head;
          }
        int l=length(head);
        
        if(l<k){
            return head;
        }
        ListNode OT=null;
        ListNode OH=null;
        ListNode curr=head;
        int K=k;
        while(curr!=null && l>=K){
            while(K--> 0)
            {
                ListNode next=curr.next;
                curr.next=null;
                
                firstadd(curr);
                
                curr=next;
            }
            l-=k;
            K=k;
            if(OH==null){
                OH=TH;
                OT=TT;
            }
            else{
                OT.next=TH;
                OT=TT;
            }
            TT=null;
            TH=null;
               
        }
        OT.next=curr;
        return OH;
    }
    static int length(ListNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
    static ListNode reverseList(ListNode head,int k){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null && k!=0){
            ListNode forward=curr.next;
            
            prev.next=curr;
            
            prev=curr;
            curr=forward;
            k--;
        }
        return prev;
    }
    
    static void firstadd(ListNode head){
        if(TT==null){
           TH=head;
           TT=head;
        }
        else{
            head.next=TH;
            TH=head;
        }
    }
}