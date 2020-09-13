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
//     bool isPalindrome(ListNode* head) {
//         if(head==nullptr || head->next==nullptr){
//             return true;
//         }
//         ListNode* mid=middle(head); //middle
//         ListNode* tHead=mid->next;
//         mid->next=nullptr;
       
//         tHead=reverseList(tHead);
//         ListNode* c1=head;
//         ListNode* c2=tHead;
        
//         bool res=true;
//         while(c1!=nullptr && c2!=nullptr){
//             if(c1->val != c2->val){
//                 res= false;
//                 break;
//             }
//             c1=c1->next;
//             c2=c2->next;
//         }
//         tHead=reverseList(tHead);
//         mid->next=tHead;
//         return res;
//     }
//     ListNode* reverseList(ListNode* head){
//         if(head==nullptr || head->next==nullptr){
//             return head;
//         }
//         ListNode* prev=nullptr;
//         ListNode* curr=head;
//         while(curr!=nullptr){
//             ListNode* forward=curr->next;
            
//             curr->next =prev; //Link 
            
//             prev=curr;//move
//             curr=forward;
//         }
//         return prev;
//     }
//     ListNode* middle(ListNode* head){
//         if(head==nullptr|| head->next==nullptr){
//             return head;
//         }
//         ListNode* slow=head;
//         ListNode* fast=head;
//         while(fast->next==nullptr && fast->next->next==nullptr){
//             slow=slow->next;
//             fast=fast->next->next;
//         }
//         return slow;
//     }
// };
    bool isPalindrome(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return true;

    ListNode *mid = middleNode2(head);
    ListNode *tHead = mid->next;
    mid->next = nullptr;

    tHead = reverseList(tHead);
    ListNode *c1 = head;
    ListNode *c2 = tHead;

    bool res = true;
    while (c1 != nullptr && c2 != nullptr)
    {
        if (c1->val != c2->val)
        {
            res = false;
            break;
        }

        c1 = c1->next;
        c2 = c2->next;
    }

    tHead = reverseList(tHead);
    mid->next = tHead;

    return res;
}
    ListNode *reverseList(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return head;

    ListNode *prev = nullptr;
    ListNode *forw = nullptr;
    ListNode *curr = head;

    while (curr != nullptr)
    {
        forw = curr->next; // backup

        curr->next = prev; // link

        prev = curr; // move
        curr = forw;
    }

    return prev;
}

    ListNode *middleNode2(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return head;

    ListNode *slow = head;
    ListNode *fast = head;

    while (fast->next != nullptr && fast->next->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
    }

    return slow;
}
};