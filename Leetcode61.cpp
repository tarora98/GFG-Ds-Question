/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(head==nullptr || head->next==nullptr ||k==0){
            return head;
        }
        ListNode* curr=head;
        int len=0;
        while(curr!=nullptr){
            curr=curr->next;
            len++;
        }
        k%=len;
        if(k==0){
            return head;
        }
        ListNode* c1=head;
        ListNode* c2=head;
        while(k-->0){
            c2=c2->next;
        }
        while(c2->next!=nullptr){
            c1=c1->next;
            c2=c2->next;
        }
        c2->next=head;
        head=c1->next;
        c1->next=nullptr;
        return head;
    }
};