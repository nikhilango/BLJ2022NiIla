#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

int main() {
    int delNum = 13;
    TNode *head = NULL;
    head = (TNode *) malloc(sizeof(TNode));

    head->data = 1;
    head->next = (TNode *) malloc(sizeof(TNode));
    head->next->data = 2;
    head->next->next = (TNode *) malloc(sizeof(TNode));
    head->next->next->data = 3;
    head->next->next->next = (TNode *) malloc(sizeof(TNode));
    head->next->next->next = NULL;

    printList(head);
    printf("-------------Printing list-------------\n");
    for (int i = 0; i < 10; ++i) {
        addNode(head);
    }
    printList(head);
    printf("-------------Deleting node-------------\n");
    delNode(head);
    printList(head);
    printf("--------Adding node at 4th index-------\n");
    addNodeAtIndex(head);
    printList(head);
    printf("-------Printing node of 9th index------\n");
    printListAtIndex(head);

    return 0;
}


