#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void initCreateSecClock();
void initSecClock();
void createSecClock();
void currentTime();



char secClock[11][11] = {};
int timeSec = 0;
int timeMin = 0;
int main() {
    initSecClock();
    secClock[2][3] = '|';
    secClock[1][3] = '|';
    secClock[0][3] = '^';
    while (1){
        for (int i = 0; i < 59; i++) {
            sleep(1);
            system("cls");
            currentTime(&timeSec);
            printf("\n                 %dmin %ds\n", timeMin, timeSec);
            initCreateSecClock(&timeSec);

        }
        timeMin++;
        timeSec = 0;
    }
    return 0;
}



void initCreateSecClock(int *time){
    switch (*time) {
        case 15:
            initSecClock();
            secClock[3][3] = 'o';
            secClock[3][4] = '-';
            secClock[3][5] = '-';
            secClock[3][6] = '>';
            createSecClock();
            break;
        case 30:
            initSecClock();
            secClock[3][3] = 'o';
            secClock[4][3] = '|';
            secClock[5][3] = '|';
            secClock[6][3] = '|';
            createSecClock();
            break;
        case 45:
            initSecClock();
            secClock[3][3] = 'o';
            secClock[3][2] = '-';
            secClock[3][1] = '-';
            secClock[3][0] = '<';
            createSecClock();
            break;
        case 1:
            initSecClock();
            secClock[3][3] = 'o';
            secClock[2][3] = '|';
            secClock[1][3] = '|';
            secClock[0][3] = '^';
            createSecClock();
            break;
        default:

            createSecClock();
    }
}


void currentTime(int *time){
        *time = *time + 1;
}

void initSecClock(){
    for (int c = 0; c < 7; c++) {
        for (int d = 0; d < 7; d++) {
            secClock[c][d] = 'o';
        }
    }
}
void createSecClock(){
    printf("                    |\n");
    printf("                    _\n");
    printf("                   /-\\\n");
    printf("                  /---\\\n");
    printf("                 /-----\\\n");
    printf("                |-------|\n");
    printf("                |-------|\n");
    printf("                |-------|\n");
    printf("                /-------\\\n");
    printf("              |/---------\\|\n");
    printf("              /-----------\\\n");
    printf("            |/-------------\\|\n");
    printf("            +---------------+\n");
    for (int c = 0; c < 7; c++) {
        printf("            |");
        for (int d = 0; d < 7; d++) {
            printf(" %c", secClock[c][d]);
        }
        printf(" |\n");
    }
    printf("            +---------------+           ------- \n");
    printf("            | | | | | | | | |               |   |     ___\n");
    printf("            | | | |THIS | | |               |   |--| |___|\n");
    printf("            | | | |IS | | | |               |   |  | |___\n");
    printf("            | | | |THE| | | |\n");
    printf("            | | | |BIG| | | |\n");
    printf("            | | | |BEN| | | |           |     |      \n");
    printf("            | | | |FROM | | |           |            \n");
    printf("            | | | LONDON| | |           |---| | |---|\n");
    printf("            | | | | | | | | |           |___| | |___|\n");
    printf("            | | | | | | | | |                       |\n");
    printf("            | | | | | | | | |                    ---|\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |             |    \n");
    printf("            | | | | | | | | |             |      ___   ___\n");
    printf("            | | | | | | | | |             |---| |___| |   |\n");
    printf("            | | | | | | | | |             |___| |___  |   |\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |\n");
    printf("            | | | | | | | | |\n");
    printf("            +---------------+\n");
}

