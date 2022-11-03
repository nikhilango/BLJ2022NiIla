#include <stdio.h>
typedef struct node {
    int data;
    struct node* next;
} TNode;

void printList(TNode *p_head)
{
    TNode *current_node = p_head;
    while ( current_node != NULL) {
        printf("%d\n", current_node->data);
        current_node = current_node->next;
    }
}

