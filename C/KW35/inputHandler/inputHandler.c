#include <stdio.h>


void readRangedInt(int a, int b){
    int min = 0;
    int max = 10;
    if (min <= a && b >= max)
    {
        printf("Yes you typed the number in the given range!");
    }
    else {
        printf("You typed out of the number range.");
    }
    

