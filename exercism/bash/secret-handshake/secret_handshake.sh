#!/usr/bin/env bash

# 1 = wink
# 10 = double blink
# 100 = close your eyes
# 1000 = jump
# 10000 = Reverse the order
# https://stackoverflow.com/questions/10278513/bash-shell-decimal-to-binary-base-2-conversion/25943519
main () {
    binary=$(echo "obase=2;${1}" | bc)
    echo ${binary}
    for((i=0;i<${#binary};i++)); do
        val="${binary:i:1}"
        echo ${val}
    done
}

# call main with all of the positional arguments
main "$@"
