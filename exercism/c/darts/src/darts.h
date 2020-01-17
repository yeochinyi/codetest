#include "../test/vendor/unity.h"

typedef struct coordinate 
{
    double x;
    double y;
} coordinate_t;

#ifndef DARTS_H
#define DARTS_H

uint8_t score(coordinate_t landing_position);

#endif
