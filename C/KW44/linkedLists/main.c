#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

int main() {
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


    return 0;
}


