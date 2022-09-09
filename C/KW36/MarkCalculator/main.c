/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: nikhi
 *
 * Created on September 8, 2022, 2:02 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    printf("-----------------------\n");
    printf("Average Mark Calculator\n");
    printf("-----------------------\n");

    #define NUM_MARKS 5
    float nums[5];
    float result = 0;
    float average;
    float averageDivider;
    float weight[5];
    for(int i = 0; i < 5; i++){
        printf("Type a number: ");
        scanf("%f", &nums[i]);
        if(nums[i] < 1 || nums[i] > 6){
            printf("A number from 1 to 6 boi\n");
            return 0;    
        }
        printf("Enter the weight of the mark decimals: ");
        scanf("%f", &weight[i]);
    }

    printf("-----------------------\n");

    for(int x = 0; x < 5; x++){
        //nums[x] = result * weight[x];
        result = (nums[x] * weight[x]) + result;
    }
    
    for(int y = 0; y < 5; y++){
        averageDivider = weight[y] + averageDivider;
    }
    average = result / averageDivider; //averageDivider = All of the weights added together.
    printf("The average is: %.2f \n", average);

    /*
     * TODO - Extra tasks, implement only after completing all previous TODOs.
     *      - Allow for the manipulation of individual marks, using the index.
     */

    return (EXIT_SUCCESS);
}

