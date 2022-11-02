#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *next;
} TNode;


int main() {
    TNode *head = NULL;

    head->data = 1;
    head->next = (TNode *) malloc(sizeof(TNode));
    head->next->data = 2;
    head->next->next = (TNode *) malloc(sizeof(TNode));
    head->next->next->data = 3;
    head->next->next->next = (TNode *) malloc(sizeof(TNode));
    head->next->next->next = NULL;


    printf("%d\n", head->next->next->data);

    return 0;
}
