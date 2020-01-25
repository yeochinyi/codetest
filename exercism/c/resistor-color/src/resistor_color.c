#include "resistor_color.h"

int color_code(resistor_band_t resistor_color){
    return resistor_color;
}

static resistor_band_t expected[] = {
    BLACK, BROWN, RED, ORANGE, YELLOW,
    GREEN, BLUE, VIOLET, GREY, WHITE
};


resistor_band_t * colors(){
   return expected;
}
