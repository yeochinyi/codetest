#include "hello_world.h"

#include <stdio.h>

const char *hello(void)
{
    return "Hello, World!";
}

void main(char* args){
    printf("%s",hello());
}