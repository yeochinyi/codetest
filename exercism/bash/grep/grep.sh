#!/usr/bin/env bash

set -euo pipefail

main () {
    # Usage: grep.sh -flags [-flags] searchstring file1.txt [file2.txt]
    # -n Print the line numbers of each matching line.
    # -l Print only the names of files that contain at least one matching line.
    # -i Match line using a case-insensitive comparison.
    # -v Invert the program -- collect all lines that fail to match the pattern.
    # -x Only match entire lines, instead of lines that contain a match.

    local searchString=""
    local printLineNum=false
    local printFileNameMatchOne=false
    local printInvert=false
    local printMatchEntireLine=false
    
    declare -a files
    for (( i=1;i<${#@}+1;i++ )){
        # echo ${i}=${!i:0:1}
        if [[ ${!i:0:1} == '-' ]]; then
            # echo "flag=${!i}"
            case ${!i:1:1} in
            n)
                printLineNum=true
                ;;
            l)
                printFileNameMatchOne=true
                ;;
            i)
                shopt -s nocasematch
                ;;
            v)
                printInvert=true
                ;;
            x)
                printMatchEntireLine=true
                ;;
            *)
                # echo "No flags"
                ;;
            esac

        elif [[ "$searchString" == "" ]]; then
            searchString=${!i}
            if ${printMatchEntireLine} ; then
                searchString="^${searchString}$"
            fi
            # echo "searchString=${searchString}"
        else
            # echo "file=${!i}"
            files+=( ${!i} )
        fi 
    }
    # echo "files=${files[@]}"
    local isMultiple=false
    if [[ ${#files[@]} > 1  ]]; then
        isMultiple=true
    fi

    for (( i=0;i<${#files[@]};i++ )){
        # echo "loop=${files[i]}"
        # https://www.cyberciti.biz/faq/unix-howto-read-line-by-line-from-file/
        local fileLineNum=1
        while IFS= read -r line; do
            # echo "$line"
            local matching=false
            if [[ ${line} =~ ${searchString} ]]; then
                matching=true
            fi
            if ( ${printInvert} && ! ${matching} ) || ( ! ${printInvert} && ${matching} ); then
                if ${printFileNameMatchOne}; then
                    echo "${files[i]}"
                    break
                fi
                local linePrefix=""
                if ${isMultiple}; then
                    linePrefix="${files[i]}:"
                fi
 
                if ${printLineNum}; then
                    linePrefix="${linePrefix}${fileLineNum}:"
                fi

                echo "${linePrefix}${line}"
            fi
            fileLineNum=$((fileLineNum+1))
        done < "${files[i]}"
    }
}
main "$@"
