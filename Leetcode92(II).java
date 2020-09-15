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
    private ListNode OT = null;
    private ListNode OH = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null ||m==n) {
            return head;            
        }
        
        ListNode curr=head;
        ListNode prev=null;
        int idx=1;
        while(curr!=null){
            
            while(idx>=m && idx<=n)
            {
                ListNode next=curr.next;
                
                 curr.next=null;
                
                 firstadd(curr);
                 
                 curr=next;
                 idx++;
            }
            
            //when come out from while then idx>n{
            
            if(idx>n){
                
                if(prev==null){
                    head=OH;
                } else{
                    prev.next=OH;
                }
                
                OT.next=curr;
                break;
            }
            
            //if not in range
            prev=curr;
            curr=curr.next;
            idx++;
        }
        return head;       
    }
    
    private void firstadd(ListNode head){
       if(OH==null){
           OH=head;
           OT=head;
       }
       else{
           head.next=OH;
           OH=head;
       }
    }
}