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
    printf("\n-------------Printing list-------------\n");
    for (int i = 0; i < 10; ++i) {
        addNode(head);
    }
    printList(head);
    printf("\n-------------Deleting node-------------\n");
    delNode(head);
    printList(head);
    printf("\n--------Adding node at 5th index-------\n");
    addNodeAtIndex(head);
    printList(head);
    printf("\n-------Printing node of 5th index------\n");
    printListAtIndex(head);
    printf("\n-------Changing node at 5th index------\n");
    changeNode(head);
    printList(head);
    printf("\n-----------Changing all nodes----------\n");
    changeAllNodes(head);
    printList(head);
    printf("\n---------------List lenght-------------\n");
    calcLength(head);
    printf("\n-------------Deleted List------------\n");
    delList(head);
    return 0;
}


