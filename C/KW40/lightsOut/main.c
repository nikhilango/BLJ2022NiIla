#include <stdio.h>
#include <stdlib.h>
#include "functions.h"
#include <time.h>
#include <stdbool.h>
int generateRandomNum();
void printArea();
int randomNum();
int curStat = 0;
char area[5][5] = {'0'};
//{'#', '.', '.', '#', '.'},
//{'.', '.', '#', '.', '.'},
//{'.', '#', '.', '.', '.'},
//{'#', '.', '.', '.', '.'},
//{'.', '.', '#', '#', '.'}
int main() {
    bool gameWon = true;
    int row = 0;
    int column = 0;
    srand(time(NULL));
    
    for (int i = 0; i < 5; i++) {
        for (int c = 0; c < 5; c++) {
            curStat = randomNum();
            if(curStat == 0){
                area[i][c] = '#';
            }
            else if(curStat == 1){
                area[i][c] = '.';
            }
        }
    }

    printArea();

    do{

    printf("\nInput:");
    scanf("%d %d", &column, &row);


    if(area[row][column] == '#'){
        area[row][column] = '.';
    }

    else if(area[row][column] == '.'){
        area[row][column] = '#';
    }

    if(area[row + 1][column] == '#'){
        area[row + 1][column] = '.';
    }

    else if(area[row + 1][column] == '.'){
        area[row + 1][column] = '#';
    }

    if(area[row - 1][column] == '#'){
        area[row - 1][column] = '.';
    }

    else if(area[row - 1][column] == '.'){
        area[row - 1][column] = '#';
    }

    if(area[row][column + 1] == '#'){
        area[row][column + 1] = '.';
    }

    else if(area[row][column + 1] == '.'){
        area[row][column + 1] = '#';
    }

    if(area[row][column - 1] == '#'){
        area[row][column - 1] = '.';
    }

    else if(area[row][column - 1] == '.'){
        area[row][column - 1] = '#';
    }

    system("cls");
    printArea();


    } while (gameWon);
    return 0;
}

void printArea(){
    int counter = 0;
    printf("  |-0-|-1-|-2-|-3-|-4-|\n");
    printf("  +---+---+---+---+---+");
    for (int i = 0; i < 5; i++) {
        printf("\n%d |", counter);
        counter++;
        for (int c = 0; c < 5; c++) {
            printf(" %c ", area[i][c]);
            printf("|");
        }
        printf("\n  +---+---+---+---+---+");
    }

    printf("\n");
}
int randomNum(){

    int status = rand() % 2;

    return(status);
}