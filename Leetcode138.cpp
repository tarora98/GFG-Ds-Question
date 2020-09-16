/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
       if(head==nullptr){
           return head;
       }         
       copyNode(head);
       LinkNode(head);
       return ExtractLinkedList(head);
        
    }
    void copyNode(Node* head){// copy function
        Node* curr=head;
        while(curr!=nullptr){
            Node* nextnode=curr->next;
            
            Node* node=new Node(curr->val);
            
            curr->next=node;
            node->next=nextnode;
            curr=nextnode;
        }
    }
    
    void LinkNode(Node* head){
        Node* curr=head;
        while(curr!=nullptr){
        // cout<<curr->next->random->val<<endl;
        if(curr->random !=nullptr){
            // cout<<curr->next->random->val<<endl;
        curr->next->random=curr->random->next;///////////// main important part to connect 
        }
        curr=curr->next->next;
        }
    }
    
    Node* ExtractLinkedList(Node* head){
        Node* dummy=new Node(-1);
        Node* prev=dummy;
        Node* curr=head;
        while(curr!=nullptr){
       
        prev->next=curr->next;//Link
        curr->next=curr->next->next;
        
        prev=prev->next;    //Move
        curr=curr->next;
    }
        return dummy->next;
    }
};