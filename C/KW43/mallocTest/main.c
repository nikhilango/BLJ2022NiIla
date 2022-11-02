#include <stdio.h>
#include <stdlib.h>
typedef struct tvshows {
    char title[20];
    char author[20];
    int published;
} Ttvshows;


int main() {
    Ttvshows tvshows1;
    tvshows1.published = 13112006;

    Ttvshows *arr = (Ttvshows*) malloc(17000000000 * sizeof(Ttvshows));

    for (int i = 0; i < 17000000000; i++) {
        printf("%d", arr[i].published);
    }
    return 0;
}
