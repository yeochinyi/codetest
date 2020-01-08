#!/usr/bin/env bash

# return 2 numbers representing resistor colors
main () {
    # Ref https://www.artificialworlds.net/blog/2012/10/17/bash-associative-array-examples/

    declare -A colors=(
        ["black"]=0 ["brown"]=1 ["red"]=2 
        ["orange"]=3 ["yellow"]=4 ["green"]=5 
        ["blue"]=6 ["violet"]=7 ["grey"]=8 ["white"]=9
    )

    ret=""
    i=0
    for var in "$@"
    do
        if [[ ${colors[${var}]+_} ]]; then
            ret="$ret${colors[${var}]}"
        else
            echo "invalid color"
            exit 1
        fi
        if (( ++i == 2 )); then
            echo "$ret"
        fi
    done
}

# call main with all of the positional arguments
main "$@"
