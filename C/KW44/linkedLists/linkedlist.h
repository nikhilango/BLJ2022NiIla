#ifndef MAIN_C_LINKEDLIST_H
#define MAIN_C_LINKEDLIST_H
typedef struct node {
    int data;
    struct node* next;
} TNode;

void printList(TNode *p_head);
void printListAtIndex(TNode *p_head);
void addNode(TNode *p_head);
void addNodeAtIndex(TNode *p_head);
void delNode(TNode *p_head);

#endif MAIN_C_LINKEDLIST_H