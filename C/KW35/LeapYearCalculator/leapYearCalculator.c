#include <stdio.h>
int isLeapYear(int year);
int daysInMonth(int month, int year);
void printDateInfo(int month, int year);
int main() {
    int month = 2;
    int year = 2024;
    
    printf("Enter a month(1-12): ");
    scanf("%d", &month);
    
    printf("Enter a year: ");
    scanf("%d", &year);
    
    // todo get user input for month and year 
    // todo third
    printDateInfo(month, year);
    
    return 0;
}
int isLeapYear(int year){

     if (year % 400 == 0) {
      return(1);
   }
   
   else if (year % 100 == 0) {
      return(1);
   }
   
   else if (year % 4 == 0) {
      return(1);
   }
   
   else {
      return(0);
   }
}
int daysInMonth(int month, int year){
    
    //February---------------------------------------------------------------
    if (month == 2 && isLeapYear(year)==0){
        return(28);
    }

    else if (month == 2 && isLeapYear(year)==1){
        return(29);
    }
    //-----------------------------------------------------------------------
    
    // every month with 30 days
    if (month >= 7 && month != 2 && month % 2 == 1){
        return(30);
    }

    else if (month <= 8 && month != 2 && month % 2 == 0){
        return(30);
    }
    //-----------------------------------------------------------------------
    
    // every month with 31 days
    else if (month >= 7 && month != 2 && month % 2 == 0){
        return(31);
    }
    
    else if (month <= 8 && month != 2 && month % 2 == 1){
        return(31);
    }
    
    
    // to do second
    // returns 30, 31, 28 or 29
}
void printDateInfo(int month, int year){
    int days = daysInMonth(month, year);
    
    printf("Der Monat %d hat im Jahr %d %d Tage. \n", month, year, days);
    
    printf("Das Jahr %d ist ", year);
    if(!isLeapYear(year)){
        printf("kein ");
    }else{
        printf("ein ");
    }
    printf("Schaltjahr. \n");
}