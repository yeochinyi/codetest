#include "hello_world.h"
#include <stdio.h>


const char *hello(void)
{
    return "Hello, World!";
}

int main() {
    printf(hello());
    return 0;
}