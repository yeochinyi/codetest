#include <math.h>
#include "darts.h"

// return score of landing position
uint8_t score(coordinate_t landing_position){
    double len_sq = pow(landing_position.x,2) + pow(landing_position.y,2);
    double len = pow(len_sq,0.5);

    // If the dart lands outside the target, player earns no points (0 points).
    // If the dart lands in the outer circle (radius 10) of the target, player earns 1 point.
    // If the dart lands in the middle circle (radius 5) of the target, player earns 5 points.
    // If the dart lands in the inner circle (radius 1) of the target, player earns 10 points.

    if(len <= 1){
        return 10;
    }
    else if(len <= 5){
        return 5;
    }
    else if(len <= 10){
        return 1;
    }
    return 0;
}