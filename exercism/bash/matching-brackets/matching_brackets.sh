#!/usr/bin/env bash

# return true if all brackets matches
main () {

  arr=()

  declare -A matching=( ['{']='}' ['(']=')' ['[']=']' )

  for ((i=0;i<${#1};i++)); do
    curr=${1:$i:1}
    # echo "i=${i}, curr="${curr}", first=${arr[0]}, last=${arr[-1]} len=${#arr[@]}, all=${arr[@]}"
    if [[ $curr =~ ^(\{|\[|\()$ ]]; then
        arr+=( ${matching[${curr}]} )
    elif [[ ${curr} =~ ^(\}|\]|\))$ ]]; then
        if (( ${#arr[@]} == 0 )) || [[ ${curr} != ${arr[-1]} ]]; then
            echo "false"
            exit 0
        else            
            unset arr[${#arr[@]}-1]
        fi
     fi    
  done
  # if there are remaining items in the queue
  if (( ${#arr[@]} > 0 )); then
    echo "false"
    exit 0
  fi

  echo "true"
}

# call main with all of the positional arguments
main "$@"
