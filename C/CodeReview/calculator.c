int calcPow(int base, int exp){
    if(exp == 0){ return 1; }
    
    int result = base;
    
    while(exp > 1){             // space between operators
        exp--;
        result = result * base;
    }
    
    return result;
}

int squareRoot(int sqaure){
    int c = 2;
    while(c > 1){               // space between operators
        if(c * c == sqaure){    // space between operators
            break;                  //
            c += 2;                 //-tab
            return c;               //
        }                       // bracet formation
        c++;
    }
    return c;
}