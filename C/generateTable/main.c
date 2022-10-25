#include <stdio.h>
#include <stdlib.h>

int main() {
    int col = 0;
    int row = 0;
    int skeleton = 0;
    int header = 0;
    int styles = 0;
    
    printf("Enter the amount of collumns: ");
    scanf("%d", &col);
    printf("\nEnter the amount of rows: ");
    scanf("\n%d", &row);
    printf("\nDo you want an HTML skeleton? (1/0)");
    scanf("\n%d", &skeleton);
    printf("\nDo you want a header? (1/0)");
    scanf("\n%d", &header);
    printf("\nDo you want the styles too? (1/0)");
    scanf("\n%d", &styles);
    printf("\nHTML: ");
    printf("\n------------------------------------------------------------------------------\n");
    switch (styles) {

        case 0:
        switch (skeleton) {

            case 0:
                switch (header) {
                    case 0:
                        for (int i = 0; i < row; i++) {
                            printf("<tr class=\"rows\">\n");
                            for (int j = 0; j < col; j++) {
                                printf("    <th class=\"cell\">\n>text</th>\n");
                            }
                            printf("</tr class=\"rows\">\n");
                            printf("\n");
                        }
                        break;
                    case 1:
                        printf("<thead>\n");
                        for (int a = 0; a < row; a++) {
                            printf("    <tr class=\"rows\">\n>\n");
                            for (int b = 0; b < col; b++) {
                                printf("        <thclass=\"cell\">text</th>\n");
                            }
                            printf("    </tr class=\"rows\">\n");
                            printf("\n");
                        }
                        printf("</thead>\n");
                        break;
                }
                break;

            case 1:
                switch (header) {
                    case 0:
                        printf("<!DOCTYPE html>\n");
                        printf("<html>\n");
                        printf("    </head>\n");
                        printf("        <title>untitled</title>\n");
                        printf("    </head>\n");
                        printf("    <body>\n");
                        for (int i = 0; i < row; i++) {
                            printf("       <tr class=\"rows\">\n>\n");
                            for (int j = 0; j < col; j++) {
                                printf("            <th class=\"cell\">text</th>\n");
                            }
                            printf("        </tr class=\"rows\">\n>\n");
                            printf("\n");
                        }
                        printf("    <body>\n");
                        printf("<html>\n");


                        break;
                    case 1:
                        printf("<!DOCTYPE html>\n");
                        printf("<html>\n");
                        printf("    </head>\n");
                        printf("        <title>untitled</title>\n");
                        printf("    </head>\n");
                        printf("    <body>\n");
                        printf("        <thead>\n");
                        for (int a = 0; a < row; a++) {
                            printf("            <tr class=\"rows\">\n");
                            for (int b = 0; b < col; b++) {
                                printf("                <th class=\"cell\">text</th>\n");
                            }
                            printf("            </tr class=\"rows\">\n");
                            printf("\n");
                        }
                        printf("        </thead>\n");
                        printf("    <body>\n");
                        printf("<html>\n");
                        break;
                }
                break;
        }
            break;
        case 1:
            switch (skeleton) {

                case 0:
                    switch (header) {
                        case 0:
                            for (int i = 0; i < row; i++) {
                                printf("<tr class=\"rows\">\n");
                                for (int j = 0; j < col; j++) {
                                    printf("    <th class=\"cell\">\n>text</th>\n");
                                }
                                printf("</tr class=\"rows\">\n");
                                printf("\n");
                            }
                            break;
                        case 1:
                            printf("<thead>\n");
                            for (int a = 0; a < row; a++) {
                                printf("    <tr class=\"rows\">\n>\n");
                                for (int b = 0; b < col; b++) {
                                    printf("        <thclass=\"cell\">text</th>\n");
                                }
                                printf("    </tr class=\"rows\">\n");
                                printf("\n");
                            }
                            printf("</thead>\n");
                            break;
                    }
                    break;

                case 1:
                    switch (header) {
                        case 0:
                            printf("<!DOCTYPE html>\n");
                            printf("<html>\n");
                            printf("    </head>\n");
                            printf("        <title>untitled</title>\n");
                            printf("    </head>\n");
                            printf("    <body>\n");
                            for (int i = 0; i < row; i++) {
                                printf("       <tr class=\"rows\">\n>\n");
                                for (int j = 0; j < col; j++) {
                                    printf("            <th class=\"cell\">text</th>\n");
                                }
                                printf("        </tr class=\"rows\">\n>\n");
                                printf("\n");
                            }
                            printf("    <body>\n");
                            printf("<html>\n");


                            break;
                        case 1:
                            printf("<!DOCTYPE html>\n");
                            printf("<html>\n");
                            printf("    </head>\n");
                            printf("        <title>untitled</title>\n");
                            printf("    </head>\n");
                            printf("    <body>\n");
                            printf("        <thead>\n");
                            for (int a = 0; a < row; a++) {
                                printf("            <tr class=\"rows\">\n");
                                for (int b = 0; b < col; b++) {
                                    printf("                <th class=\"cell\">text</th>\n");
                                }
                                printf("            </tr class=\"rows\">\n");
                                printf("\n");
                            }
                            printf("        </thead>\n");
                            printf("    <body>\n");
                            printf("<html>\n");
                            break;
                    }
                    break;
            }
            printf("------------------------------------------------------------------------------\n");
            printf("\nCSS: ");
            printf("\n------------------------------------------------------------------------------\n");
            printf("body{\n");
            printf("    padding: 30px;\n");
            printf("    background-color: lightgrey;\n");
            printf("}\n");

            printf(".rows{\n");
            printf("    padding: 10px;\n");
            printf("    background-color: rose;\n");
            printf("}\n");

            printf(".cell{\n");
            printf("    padding: 5px;\n");
            printf("    background-color: lightblue;\n");
            printf("}\n");
            printf("------------------------------------------------------------------------------\n");
            break;
    }
    return 0;
}
