#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int *getRandomNums(unsigned int n);

int main() {
    unsigned int n = 0;
    printf("Enter the amount of random numbers: ");
    scanf("%u", &n);
    if(n < 0){
        return 0;
    }
    int randomNumbers;
    srand(time(NULL));

    getRandomNums(n);


    return 0;
}

int *getRandomNums(unsigned int n){
    int randomNum = 0;
    int *randomNumbers = malloc(n * sizeof(int));
    if(randomNumbers == NULL){
        exit(1);
    }

    for (int i = 0; i < n; i++) {
        randomNum = rand() % 100;
        *(randomNumbers + i) = randomNum;
    }
    for (int i = 0; i < n; i++) {
        printf("%d, ", *(randomNumbers + i));
    }
}