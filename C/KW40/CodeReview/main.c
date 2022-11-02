#include <stdio.h>
#include "calculator.h"


int main() {
    
    printf("Willkommen zum Super-Rechner!\n\nEine Rechnung wurde berechnet: \n32 im Quadrat wurde berechnet. \nDas Ergebnis lautet %d\n", calcPow(32,2));
    printf("\nEine Rechnung wurde berechnet:");
    printf("\nDie Quadratwurzel von 225 wurde berechnet. \nDie Quadratwurzel von 225 betraegt %d. \n", squareRoot(225)); // terminal can't show Umlaut
    
    return 0;
}