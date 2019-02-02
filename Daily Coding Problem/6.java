/* #include <iostream>

struct Node{
    int data;
    struct Node* npx;
};

struct Node* XOR (struct Node* a, struct Node* b){
    return (struct Node*) ((uintptr_t) (a) ^ (uintptr_t) (b));
};

void insert(struct Node **head_ref, int data){
    struct Node *new_node = (struct Node *) malloc (sizeof (struct Node));
    new_node->data = data;
    
    new_node->npx = XOR(*head_ref, NULL);
    
    if(*head_ref != NULL){
        struct Node* next = XOR((*head_ref)->npx, NULL);
        (*head_ref)->npx = XOR(new_node, next);
    }
    
    *head_ref = new_node;
}

void printList (struct Node *head) 
{ 
    struct Node *curr = head; 
    struct Node *prev = NULL; 
    struct Node *next; 
  
    printf ("Following are the nodes of Linked List: \n"); 
  
    while (curr != NULL) 
    { 
        // print current node 
        printf ("%d ", curr->data); 
  
        // get address of next node: curr->npx is  
        // next^prev, so curr->npx^prev will be 
        // next^prev^prev which is next 
        next = XOR (prev, curr->npx); 
  
        // update prev and curr for next iteration 
        prev = curr; 
        curr = next; 
    } 
}

int main() {
    // Create following Doubly Linked List 
    //head-->40<-->30<-->20<-->10
    struct Node *head = NULL; 
    insert(&head, 10); 
    insert(&head, 20); 
    insert(&head, 30); 
    insert(&head, 40); 
  
    // print the created list 
    printList (head); 
  
    return (0); 
}
 */