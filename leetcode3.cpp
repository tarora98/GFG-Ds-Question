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
//Leetcode143
class Solution {
    public:
        void reorderList(ListNode* head) {
            if(head==nullptr || head->next==nullptr){
                return;
            }
            ListNode* mid=middle(head);
            ListNode* tHead=mid->next;
            mid->next=nullptr;
            
            tHead=reverseList(tHead);
            
            ListNode* c1=head;
            ListNode* c2=tHead;
            ListNode* f1=nullptr;
            ListNode* f2=nullptr;
            while(c1!=nullptr && c2!=nullptr){
                f1=c1->next;
                f2=c2->next;//backup
                
                c1->next=c2;//move
                c2->next=f1;
                
                c1=f1;
                c2=f2;
            }
            // return;
                    
        }
        ListNode* middle(ListNode* head){
           if(head==nullptr || head->next==nullptr){
                return head;
            }
            ListNode* slow=head;
            ListNode* fast=head;
            while(fast->next!=nullptr && fast->next->next!=nullptr){
                slow=slow->next;
                fast=fast->next->next;
            }
            return slow;
        }
        ListNode* reverseList(ListNode* head){
           if(head==nullptr || head->next==nullptr){
                return head;
            }
            ListNode* prev=nullptr;
            ListNode* curr=head;
            while(curr!=nullptr){
                ListNode* forward=curr->next;//backup
                
                //Link
                curr->next=prev;
                //move
                prev=curr;
                curr=forward;           
            }
            return prev;
        }
    };