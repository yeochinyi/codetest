#!/usr/bin/env bash

# find leap year
main () {
    if(($#!=1)) || ! [[ "$1" =~ ^[0-9]+$ ]] || (($1<0)); then 
        echo 'Usage: leap.sh <year>'
        exit 1; 
    fi
#   an every year that is evenly divisible by 4
#   except every year that is evenly divisible by 100
#   unless the year is also evenly divisible by 400
    if(($1%400==0)); then echo 'true'; return; fi
    if(($1%100==0)); then echo 'false'; return; fi
    if(($1%4==0)); then echo 'true'; return; fi
    echo 'false'
}
main "$@"

