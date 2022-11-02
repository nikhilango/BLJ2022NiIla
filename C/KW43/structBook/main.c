#include <stdio.h>
#include <string.h>

typedef struct Book {
    char title[20];
    char author[20];
    int published;
    int pages;
} TBook;

void printBook(TBook book){
    printf("---------BOOKS--------- \n");
    printf("Title: %s \n", book.title);
    printf("Author: %s \n", book.author);
    printf("Published: %d \n", book.published);
    printf("Pages: %d\n", book.pages);
    printf("----------------------- \n");
}


typedef struct Toys {
    char newborn[20];
    char baby[20];
    char kids[20];
    char teen[20];
} TToys;

void printToys(TToys toys){
    printf("----------TOYS---------- \n");
    printf("Newborn toy: %s \n", toys.newborn);
    printf("Baby toy: %s \n", toys.baby);
    printf("Kids toy: %s \n", toys.kids);
    printf("Teen toy: %s\n", toys.teen);
    printf("------------------------ \n");
}


typedef struct Cars {
    char electric[20];
    char diesel[20];
    char gasoline[20];
    char hydrogen[20];
} TCars;

void printCars(TCars cars){
    printf("----------CARS---------- \n");
    printf("Electric car: %s \n", cars.electric);
    printf("Diesel car: %s \n", cars.diesel);
    printf("Gasoline car: %s \n", cars.gasoline);
    printf("Hydrogen car: %s\n", cars.hydrogen);
    printf("------------------------ \n");
}



int main() {

    TBook book = {0};
    book.published = 1990;
    book.pages = 365;
    strcpy(book.author, "J.K Rowling");
    strcpy(book.title, "Harry Potter");

    printBook(book);


    TToys toys = {0};
    strcpy(toys.newborn, "Rattle");
    strcpy(toys.baby, "LEGO");
    strcpy(toys.kids, "Barbie");
    strcpy(toys.teen, "PS5/XBox Series X");

    printToys(toys);


    TCars cars = {0};
    strcpy(cars.electric, "Tesla Model S");
    strcpy(cars.diesel, "Mercedes Benz B-200");
    strcpy(cars.gasoline, "Audi A5");
    strcpy(cars.hydrogen, "Toyota Mirai");

    printCars(cars);

    return 0;
}