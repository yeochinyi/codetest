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

    int each_digits[10];
    int num_digits=0;
    int clone=candidate;
    while(clone!=0){
        int remain=clone%10;
        each_digits[num_digits]=remain;
        clone/=10;
        num_digits++;
    }

    int total=0;
    for(int i=0; i<num_digits;i++){
        total+=pow(each_digits[i],num_digits);
    }

    return total==candidate;
}

// int main (int argc, char *argv[]){
//     (void) argc; //get rid of compiler warning
//     int i=atoi(argv[1]);
//     printf("%d is_armstrong_number=%d\n",i, is_armstrong_number(i));
// }

