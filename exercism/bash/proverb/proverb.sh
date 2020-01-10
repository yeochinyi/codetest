#!/usr/bin/env bash

#  Prints proverb with input array
main () {
    for ((i=1;i<${#};i++)); do
        # https://www.shell-tips.com/2010/06/14/performing-math-calculation-in-bash/
        # let j=i+1 or $(expr i+1)
        j=$((i+1))
        echo "For want of a ${!i} the ${!j} was lost."
    done

    if ((${#}!=0)); then
        echo "And all for the want of a ${1}."
    fi
}

main "$@"
