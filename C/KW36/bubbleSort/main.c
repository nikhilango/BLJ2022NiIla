/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: nikhi
 *
 * Created on September 9, 2022, 8:39 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*
 * 
 */

int main(int argc, char** argv) {
    
    int nums[7];
    
    for(int y = 0; y < 7; y++){
        printf("Type any number: ");
        scanf("%d", &nums[y]);
    }
    
    
    
    for(int rep = 0; rep < 7; rep++){
        for(int i = 0; i < 6; i++){
            if(nums[i] > nums[i + 1]){
                int temp = nums[i + 1]; 
                nums[i + 1] = nums[i];
                nums[i] = temp;
                
            } 
            
        }
    }
    printf("The numbers sorted are: \n");
    for(int x = 0; x < 7; x++){
    printf("%d, ", nums[x]);
    }
    

    int numToScan;
    int minIndex = 0;
    int maxIndex = 6;
    int midIndex;
    bool numberFound = false;
    
    printf("Type a number that you want to search: ");
    scanf("%d", &numToScan);
    midIndex = (maxIndex + minIndex) / 2;
    
    for(int a = 0; a < 100; a++){
        
        if(numToScan == nums[midIndex] || numToScan == nums[minIndex] || numToScan == nums[maxIndex]){
            printf("The number is in the array at index: %d.\n", midIndex);
            numberFound = true;
            break;
        }
        
        
        else if(numToScan < nums[midIndex]){
            printf("-->\n");
            maxIndex = midIndex;
            midIndex = (midIndex + minIndex) / 2; 
            
        }
        
        
        else if(numToScan > nums[midIndex]){
            printf("-->\n");
            minIndex = midIndex;
            midIndex = (midIndex + maxIndex) / 2;
        }
    }
    if(numberFound == false){
        printf("The number is not in the array.\n");
    }
    return (EXIT_SUCCESS);
}

