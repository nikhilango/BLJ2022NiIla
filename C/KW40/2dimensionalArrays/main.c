#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h> 

int repMod = 1;
int repWhole = 1;

int main(int argc, char const *argv[]){

    #define MAX_COL_LENGHT 2;
    #define MAX_ROW_LENGHT 3;


    do{
        int arr[2][3] = {0};
        

    for (int row = 0; row < 2; row++){
        printf("You are at row index number: %d\n", row);
        
        for (int col = 0; col < 3; col++){
            printf("Enter a number: ");
            scanf("%d", &arr[row][col]);
        }
        
    }

    for (int row = 0; row < 2; row++){

        for (int col = 0; col < 3; col++){

            printf("%d, ", arr[row][col]);
        }
        
    }

        do{
            
        int changeRow = 0;
        int changeCol = 0;
        int mode = 0;
        
        

        printf("\nDo you want to change the value of a cell (1), or delete a cell(2), or exit (3) ");
        scanf("%d", &mode);

        if (mode == 1){

            printf("\nSelect the index of the row to replace a number: ");
            scanf("%d", &changeRow);

            printf("\nSelect the index of the collum to replace a number: ");
            scanf("%d", &changeCol);

            printf("\nThe number at the selected index is: %d", arr[changeRow][changeCol]);

            printf("\nWith what number do you want to replace it? ");
            scanf("%d", &arr[changeRow][changeCol]);

            printf("You have succesfully changed the array!\n");

            for(int changedRow = 0; changedRow < 2; changedRow++){

                for (int changedCol = 0; changedCol < 3; changedCol++){

                    printf("%d, ", arr[changedRow][changedCol]);
                }

            }
        }

        else if (mode == 2){

            printf("\nSelect the index of the row to replace a number: ");
            scanf("%d", &changeRow);

            printf("\nSelect the index of the collum to replace a number: ");
            scanf("%d", &changeCol);

            printf("\nThe number at the selected index was: %d", arr[changeRow][changeCol]);

            arr[changeRow][changeCol] = 0;

            
            printf("\nYou have succesfully deleted the cell!\n");

            for(int changedRow = 0; changedRow < 2; changedRow++){

                for (int changedCol = 0; changedCol < 3; changedCol++){
                    printf("%d, ", arr[changedRow][changedCol]);
                    }

                }   
            }

        else if (mode == 3){

            break;
        }

        else {
            printf("Enter a valid character");
        }
        
        
        printf("\nDo you want to modify another cell? (yes(1) no(0)) ");
        scanf("%d", &repMod);

        }while (repMod);

        int repMod = 0;

        printf("\nDo you want to repeat the whole thing again? (yes(1) no(0)) ");
        scanf("%d", &repWhole);

        int repWhole = 0;
    } while (repWhole);
    

    
    
    
    


    return 0;
}
