#!/usr/bin/env bash

main () {
    # # echo $@

    # if (( ${1} < 2 )); then
    #     echo ""
    #     return
    # fi

    # declare -A flags
    # for((i=2;i<(${1}+1);i++)); do
    #     # echo ${i}
    #     if [ ${flags[${i}]} ]; then
    #         # echo "ignore"
    #         continue            
    #     fi
    #     for((j=3;j<(${1}+1);j++)); do    
            
    #         if !(( ${j}%${i} )) && [ ${i} != ${j} ] ; then
    #             # echo "${j} % ${i}"
    #             flags["${j}"]=1
    #        fi
    #     done
    # done

    # # https://unix.stackexchange.com/questions/366581/bash-associative-array-printing
    # # printf "%s\n" "${!flags[@]}" "${flags[@]}" | pr -2t
    # # for i in "${!flags[@]}";do printf "%s=%s\n" "$i" "${flags[$i]}";done

    # # end=$((${1}-1))
    # # echo "end=$end"
    # # for k in $(eval echo {2..$end}); do
    # for (( k=2;k<(${1}+1);k++ )); do
    #     # printf "${k} "
    #     if [[ ${flags[${k}]} ]]; then
    #         continue            
    #     fi
    #     if [[ ${k} != 2 ]]; then
    #         printf " "
    #     fi
    #     printf "${k}"
    # done
    # # printf "${1}"

	for (( i=2 ; i <= $1 ; i++ )); do
		array[$i]=$i
	done

	i=2
	while (( j = i * i, j <= $1 )); do
		if [[ -n ${array[$i]} ]]; then
			while (( j <= $1 )); do
				unset array[$j]
				(( j += i ))
			done
		fi
		(( i++ ))
	done

	echo ${array[*]}    
}

main "$@"
