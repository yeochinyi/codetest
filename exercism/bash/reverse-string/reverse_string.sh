#!/usr/bin/env bash

# Rev string without using rev
main () {
    len=${#1}
    val=""
    for((i=len-1;i>=0;i--)); do
        val="$val${1:$i:1}"
    done
    echo "$val"
}
main "$@"

