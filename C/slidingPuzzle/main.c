#include <stdio.h>
#include "utils.h"

#define FIELD_SIZE 4

/**
 * This programm depicts an all-time classic, the sliding puzzle. The one and 
 * only 0 represents the empty slot in the sliding puzzle. Moves (sliding up, 
 * down, left, right) are always made relative to the empty slot e.g. in the
 * case of the initial state of the field, only the moves left (swap 0 with 15)
 * and up (swap 0 with 8) can be made. This programm doesn't detect whether the 
 * field is sorted. It runs as long as the user doesn't enter a 0.
 * 
 * @return 0 if the programm was successfully run.
 */
int main(void) {
    int row = 0;
    int col = 0;
    int x = 0;
    int y = 0;

    int field[FIELD_SIZE][FIELD_SIZE] = {
        { 0, 15,  1, 13},
        { 8,  5,  2,  3},
        {14,  7,  4,  9},
        {10, 11,  6, 12},
    };
    int input = 0;
    
    do {
        printField(FIELD_SIZE, field);
        scanf("%d", &input);

        switch (input){
        case 1: 
            swapValues(field[y][x + 1]);
            printField(FIELD_SIZE, field);
            break;

        case 2:    
            swapValues(field[y -1][x);
            printField(FIELD_SIZE, field);
            break;
        
        case 3:    
            swapValues(field[y -1][x);
            printField(FIELD_SIZE, field);
            break;
        
        case 4:    
            swapValues();
            printField(FIELD_SIZE, field);
            break;
        }

    } while (input != 0);
    return 0;
}

int swapValues(int *num1, int *num2) {
    int temp = *num1;
    *num1 = *num2;
    *num2 = temp;
}

int slideLeft(int x){
   
    int temp = x + 1; 
    x + 1 = x;
    x = temp;

    return(x);
}

int slideRight(int x){
   
    int temp = x - 1; 
    x - 1 = x;
    x = temp;

    return(x);
}

int slideDown(int y){
    int temp = y - 1; 
    y - 1 = y;
    y = temp;

    return(y);
}

int slideUp(int y){
    int temp = y + 1; 
    y + 1 = y;
    y = temp;

    return(y);
}

void printField(int size, int field[size][size]) {
    printf("\n+----+----+----+----+\n");
    for (int row = 0; row < size; row++) {
        printf("| ");
        for (int col = 0; col < size; col++) {
            if (field[row][col] != 0) {
                printf("%2d | ", field[row][col]);
            } else {
                printf("   | ");
            }
        }
        printf("\n+----+----+----+----+\n");
    }

    printf("+---------------+-------------+---------------+----------------+---------+\n");
    printf("| 1: Slide Left | 2: Slide Up | 3: Slide Down | 4: Slide Right | 0: Quit |\n");
    printf("+---------------+-------------+---------------+----------------+---------+\n");
}