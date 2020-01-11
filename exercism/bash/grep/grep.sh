#!/usr/bin/env bash

main () {
    # Usage: grep.sh -flags [-flags] searchstring file1.txt [file2.txt]
    # -n Print the line numbers of each matching line.
    # -l Print only the names of files that contain at least one matching line.
    # -i Match line using a case-insensitive comparison.
    # -v Invert the program -- collect all lines that fail to match the pattern.
    # -x Only match entire lines, instead of lines that contain a match.

    local searchString=""
    declare files -a
    for (( i=1;i<${#@}+1;i++ )){
        # echo ${i}=${!i:0:1}
        if [[ ${!i:0:1} == '-' ]]; then
            echo "flag=${!i}"
        elif [[ "$searchString" == "" ]]; then
            searchString=${!i}
            echo "searchString=${searchString}"
        else
            # echo "file=${!i}"
            files+=( ${!i} )
        fi 
    }
    echo "files=${files[@]}"

    for (( i=0;i<${#files[@]};i++ )){
        echo "loop=${files[i]}"
        # https://www.cyberciti.biz/faq/unix-howto-read-line-by-line-from-file/
        while IFS= read -r line; do
            # echo "$line"
            if [[ ${line} =~ ${searchString} ]]; then
                echo "found ${line}"
            fi
        done < "${files[i]}"
    }
}
main "$@"
