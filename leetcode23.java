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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==0){
            return nullptr;
        }
        return mergeKLISTS(lists, 0, lists.size()-1);
    }
    ListNode* mergeKLISTS(vector<ListNode*>& lists,int si,int ei)
    {
        if(si==ei){
            return lists[si];
        }
        int mid=(si+ei)/2;
        // cout<<lists[si]->val<<endl;
        // cout<<lists[si]->next->val<<endl;
        if(si==ei-1){ //consective number
            return mergeTwo(lists[si],lists[ei]);
        }
        else{
        return mergeTwo(mergeKLISTS(lists,si,mid),mergeKLISTS(lists,mid+1,ei));
        }
        // return nullptr;
    }
    ListNode* mergeTwo(ListNode* l1 , ListNode* l2){
        
        if(l1==nullptr || l2==nullptr){
            return (l1==nullptr?l2:l1);
        }
        
        ListNode *dummy=nullptr;
        ListNode *prev=nullptr;
        
        ListNode *c1=l1;
        ListNode *c2=l2;
        
        while(c1!=nullptr && c2!=nullptr){
            
            if(c1->val > c2->val){        
                if(dummy==nullptr){
                    dummy=c2;
                    prev=c2;
                    c2=c2->next;
                }else{
                    prev->next=c2;
                    prev=prev->next;
                    c2=c2->next;
                } 
            }else{
                 if(dummy==nullptr){
                    dummy=c1;
                    prev=c1;
                    c1=c1->next;
                }else{
                    prev->next=c1;
                    prev=prev->next;
                    c1=c1->next;
                }
            }
        }
        if(c1!=nullptr){
            prev->next=c1;
        }
        else{
            prev->next=c2;
        }
        
        prev=dummy;
//         while(prev!=nullptr){
//             cout<<prev->val<<endl;
//             prev=prev->next;
//         }
        
        return dummy;        
    }
};