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
    ListNode* removeElements(ListNode* head, int val) {
        if(head==nullptr) { ////////// isme head->next==nullptr nhi ayga due to [1] val=1 case ha isliye
            return head; 
        }
        ListNode* dummy=head;
        ListNode* prev=nullptr;
        
        /// if the first node is of val value and so on.............
        while(dummy!=nullptr && dummy->val==val){
            head=dummy->next;
            dummy=head;
        }
        
        // Now travserse it 
        while(dummy!=nullptr){
            while(dummy!=nullptr && dummy->val!=val){
                prev=dummy;
                dummy=dummy->next;
            }
            if(dummy==nullptr){
                return head;
            }
            // unlink the node
            prev->next=dummy->next;
            // iterate the dummy
            dummy=prev->next;
        }
        return head;
        
    }
};