#include <stdio.h>


int readRangedInt(int a, int b){
    int min = 0;
    int max = 10;
    
    if (min <= a && a >= max)
    {
        return(1);
    }
    else {
        return(0);
    }
}
