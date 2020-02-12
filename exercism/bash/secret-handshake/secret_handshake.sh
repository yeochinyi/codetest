#!/usr/bin/env bash

# 1 = wink
# 10 = double blink
# 100 = close your eyes
# 1000 = jump
# 10000 = Reverse the order

# Ref:
# https://stackoverflow.com/questions/10278513/bash-shell-decimal-to-binary-base-2-conversion/25943519
# https://opensource.com/article/18/5/you-dont-know-bash-intro-bash-arrays

# Return secret handshake actions based on number translated to binary
main () {
    actions=('wink' 'double blink' 'close your eyes' 'jump' 'reverse')
    outputs=()
    binary=$(echo "obase=2;${1}" | bc | rev)
    # echo "binary=${binary}"
    for ((i=0;i<${#binary};i++)); do
        val="${binary:i:1}"
        if [[ ${val} == '1' ]]; then
            action=${actions[$i]}
            if [[ ${action} == 'reverse' ]]; then
                reverse "${outputs[@]}"
                # https://stackoverflow.com/questions/12303974/assign-array-to-variable
                outputs=( "${reversed[@]}" )
            else
                outputs+=("${action}")
            fi
            # echo "fsize=${#outputs[@]}, content=${outputs[@]}"
        fi
    done
    for ((i=0;i<${#outputs[@]};i++)); do
        printf "${outputs[$i]}"
        if (( "${i}" != "${#outputs[@]}" - 1 )); then
            printf ","
        fi

    done
}

# https://linuxize.com/post/bash-functions/
reverse(){ 
    reversed=();
    local i;
    for ((i=$#;i>0;i--)); do 
        reversed+=( "${!i}" )
    done; 
}

# call main with all of the positional arguments
# main "$@"
