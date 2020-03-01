#!/usr/bin/env bash

# https://askubuntu.com/questions/678915/whats-the-difference-between-and-in-bash
main(){    
declare -A tally_array
declare -A team_array

while IFS= read -r line; do
    if [[ $line == "" ]]; then
        break
    fi
    # https://www.tutorialkart.com/bash-shell-scripting/bash-split-string/
    IFS=';'; tokens=( $line )
    __init_team "${tokens[0]}"
    __init_team "${tokens[1]}"

    if [[ ${tokens[2]} == 'win' ]]; then
        ((tally_array["${tokens[0]}-win"]++))
        ((tally_array["${tokens[0]}-pts"]+=3))
        ((tally_array["${tokens[1]}-loss"]++))
    elif [[ ${tokens[2]} == 'loss' ]]; then
        ((tally_array["${tokens[1]}-win"]++))
        ((tally_array["${tokens[1]}-pts"]+=3))
        ((tally_array["${tokens[0]}-loss"]++))
    else        
        ((tally_array["${tokens[0]}-draw"]+=1))
        ((tally_array["${tokens[1]}-draw"]+=1))
        ((tally_array["${tokens[0]}-pts"]+=1))
        ((tally_array["${tokens[1]}-pts"]+=1))
    fi

done < "${1:-/dev/stdin}"

# printf "%s\n" "${!tally_array[@]}" "${tally_array[@]}" | pr -2t

unsorted=()
# https://stackoverflow.com/questions/7442417/how-to-sort-an-array-in-bash
for i in "${!team_array[@]}"
do
    pts=${tally_array[$i-pts]}
    unsorted+=( "${pts}-${i}" )
done


IFS=$'\n' sorted=($(sort -k 1nr -t $'\t' <<<"${unsorted[*]}")); unset IFS
# printf "[%s]\n" "${sorted[@]}"

# https://www.cyberciti.biz/faq/bash-for-loop-array/
printf "Team                           | MP |  W |  D |  L |  P"
for combo in "${sorted[@]}"
do
    IFS='-'; token=( $combo )
    i=${token[1]}
    win=${tally_array[$i-win]}
    draw=${tally_array[$i-draw]}
    loss=${tally_array[$i-loss]}
    pts=${tally_array[$i-pts]}
    played=$(( ${win}+${draw}+${loss} ))
    printf "\n%-31s|  %s |  %s |  %s |  %s |  %s" "${i}" "${played}" "${win}" "${draw}" "${loss}" "${pts}"

done

}

# https://linuxize.com/post/bash-functions/
__init_team(){
    # echo "$1"
    if [[ -z ${team_array[$1]} ]]; then
        team_array["$1"]=1
        tally_array["$1-win"]=0
        tally_array["$1-loss"]=0
        tally_array["$1-draw"]=0
        tally_array["$1-pts"]=0
    fi
}
main "$@"
