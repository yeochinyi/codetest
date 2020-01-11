#include "armstrong_numbers.h"

#include <stdio.h>      /* printf, fgets */
#include <stdlib.h>     /* atoi */
#include <math.h>
#include <string.h>


// An Armstrong number is a number that is the sum of its own digits 
// each raised to the power of the number of digits.
// 9 is an Armstrong number, because 9 = 9^1 = 9
// 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
// 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
// 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
int is_armstrong_number(int candidate){

    // int digits = (int)((ceil(log10(candidate))+1)*sizeof(char)); //cannot work in windows

    int digits=0;
    int test=candidate;
    while(1){
        test/=10;
        digits++;
        if(test==0){
            break;
        }
    }

    printf("digits=%d\n",digits);

    int total=0;
    for(int i=0; i<digits; i++){
        int remain=candidate%(10^i);
        printf("remain=%d\n",remain);
        total+=pow(remain,digits);
    }
    printf("total=%d\n",total);
    return total==candidate;
}

int main (int argc, char *argv[]){
    int i=atoi(argv[1]);
    printf("%d is_armstrong_number=%d\n",i, is_armstrong_number(i));
}

