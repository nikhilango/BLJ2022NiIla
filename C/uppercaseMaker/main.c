#include <stdio.h>

char makeUppercase(char letter);

int main() {

    int repeat = 0;
    do {

        char letter = "\0";
        char sentence[] = {};
        int mode = 0;
        int asciiValueSentence = "\0";

        printf("\n1 = Letter, 0 = Sentence: ");
        scanf("%d", &mode);

        if(mode == 1){
            printf("Enter a lowercase letter: ");
            scanf("\n%c", &letter);

            makeUppercase(letter);
            char upperCaseLetter = makeUppercase(letter);

            printf("%c", upperCaseLetter);
        }

        else if(mode == 0){
            printf("Enter a Sentence: ");
            scanf("\n%s", &sentence);
            for (int i = 0; i < 100; i++) {
                asciiValueSentence = sentence[i];

                if(asciiValueSentence > 96 && asciiValueSentence < 123){
                    asciiValueSentence = sentence[i] - 32;
                    sentence[i] = asciiValueSentence;
                    printf("%c", sentence[i]);
                }

                else{
                    printf("%c", sentence[i]);
                }
            }
            printf("\n");
        }
        //repeat = 1;
        printf("Do you want to repeat? ");
        scanf("%d", &repeat);
    } while (repeat);
    return 0;
}




char makeUppercase(char letter){
    int asciiValue = letter;

    if(asciiValue > 96 && asciiValue < 123){
        asciiValue = letter - 32;
        letter = asciiValue;
        return letter;
    }
    else{
        return letter;
    }
}