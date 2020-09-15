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
            int distancePosition=0;
            while(fast!=nullptr && fast->next!=nullptr){
                slow=slow->next;
                fast=fast->next->next;
                distancePosition++;
                if(slow==fast){
                    break;
                }
            }
            if(slow!=fast){
                return nullptr;
            }
            slow=head;
            int m=0;
            int x=0;
            ListNode *node=fast;
            while(slow!=fast){
                if(fast==node){
                    m++; // m
                }
                x++;//  x distance
                slow=slow->next;
                fast=fast->next;
            }
            // calcaute Y
            int y=distancePosition-x;// x=z+(y+z)*(m-1);
            return slow=fast;
            
            
        }
    };