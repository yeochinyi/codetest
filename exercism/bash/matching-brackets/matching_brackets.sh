#!/usr/bin/env bash

# return true if all brackets matches
main () {

  arr=()

# references: 
#  https://www.artificialworlds.net/blog/2012/10/17/bash-associative-array-examples/
#  https://opensource.com/article/18/5/you-dont-know-bash-intro-bash-arrays
  declare -A matching=( ['{']='}' ['(']=')' ['[']=']' )

  declare -A close_brackets
  for k in ${!matching[@]}; do
    v=${matching[${k}]}
    close_brackets[${v}]=${k}
  done

  for ((i=0;i<${#1};i++)); do
    curr=${1:$i:1}
    # echo "i=${i}, curr="${curr}", first=${arr[0]}, last=${arr[-1]} len=${#arr[@]}, all=${arr[@]}"
    # if [[ $curr =~ ^(\{|\[|\()$ ]]; then
    key=${matching[${curr}]}
    if [[ ${key} ]]; then
        arr+=( ${key} )
    # elif [[ ${curr} =~ ^(\}|\]|\))$ ]]; then
    elif [[ ${close_brackets[${curr}]} ]]; then
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
