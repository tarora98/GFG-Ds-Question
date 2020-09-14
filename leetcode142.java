/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(head==nullptr || head->next==nullptr){
            return nullptr;
        }
        ListNode *slow=head;
        ListNode *fast=head;
        ListNode *pos=head;
        while(fast!=nullptr && fast->next!=nullptr){
            slow=slow->next;
            fast=fast->next->next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return nullptr;
        }
        slow=head;
        while(slow!=fast){
            slow=slow->next;
            fast=fast->next;
        }
        return slow=fast;
        
        
    }
};


// calcuate m according to the questipon x=z+(y+z)(m-1);
class Solution {
    public:
        ListNode *detectCycle(ListNode *head) {
            if(head==nullptr || head->next==nullptr){
                return nullptr;
            }
            ListNode *slow=head;
            ListNode *fast=head;
            ListNode *pos=head;
            while(fast!=nullptr && fast->next!=nullptr){
                slow=slow->next;
                fast=fast->next->next;
                if(slow==fast){
                    break;
                }
            }
            if(slow!=fast){
                return nullptr;
            }
            slow=head;
            int count=0;
            ListNode *node=fast;
            while(slow!=fast){
                if(fast==node){
                    count++; // m
                }
                slow=slow->next;
                fast=fast->next;
            }
            return slow=fast;
            
            
        }
    };
    ///count==m count which is m