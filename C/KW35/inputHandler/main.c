#include <stdio.h>
#include "function.h"

int main(int argc, char const *argv[]){

    int a;
    int b;

    printf("Enter a number between 0 and 10: ");
    scanf("%d", &a);
    
    readRangedInt(a);
    int correct = readRangedInt(a);
    
    if(correct == 1){
        printf("You typed the number out of the range.\n");
    }
    else{
        printf("You typed the number in the range.\n");
    }
    return 0;
}