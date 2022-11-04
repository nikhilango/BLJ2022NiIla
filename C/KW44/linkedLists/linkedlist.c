#include <stdio.h>
#include <stdlib.h>
typedef struct node {
    int data;
    struct node* next;
} TNode;

void printList(TNode *p_head){
    TNode *current_node = p_head;
    while ( current_node != NULL) {
        printf("%d\n", current_node->data);
        current_node = current_node->next;
    }
}

void printListAtIndex(TNode *p_head){
    int index = 0;
    TNode *current_node = p_head;
    current_node->next->next->next= index;
    while ( current_node != index) {
        current_node = current_node->next;
    }
    printf("%d\n", current_node->data);
}
int val = 4;
void addNode(TNode *p_head){
    struct node *newNode = malloc(sizeof(struct node));
    newNode->data = val;
    newNode->next = NULL;

    if(p_head == NULL){
        p_head = newNode;
    }

    else{
        struct node *lastNode = p_head;

        while(lastNode->next != NULL){
            lastNode = lastNode->next;
        }

        lastNode->next = newNode;
    }
    val++;
}

void addNodeAtIndex(TNode *p_head){
    int index = 0;
    struct node *newNode = malloc(sizeof(struct node));
    newNode->data = 1000;
    newNode->next = NULL;

    if(p_head == NULL){
        p_head = newNode;
    }

    else{
        struct node *lastNode = p_head;
        lastNode->next->next->next->next = index;

        while(lastNode->next != index){
            lastNode = lastNode->next;
        }

        lastNode->next = newNode;
    }
}

void delNode(TNode *p_head){
    struct node *temp = p_head, *prev;

    while (temp != NULL){
        prev = temp;
        temp = temp->next;
        if(temp->data == 4){
            printf("Number was found\n");
            break;
        }
    }

    if (temp == NULL){
        printf("test");
        return;
    }

    prev->next = temp->next;
    free(temp);

    printf("The cell has been deleted\n");
}
