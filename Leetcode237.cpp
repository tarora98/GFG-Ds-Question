/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

/// Ask to the interview first about this ..........................................
///////// For the  dicussion purpose



class Solution {
public:
    void deleteNode(ListNode* node) {
        if(node==nullptr || node->next==nullptr){
            return;
        }
        ListNode* temp=node->next;
        node->val=temp->val;
        node->next=temp->next;
        temp=nullptr; //////// this is the step previosuly i am doing mistake
    }
};