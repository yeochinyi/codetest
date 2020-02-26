#!/usr/bin/env bash

main(){
    
    input=$( cat <<INPUT
Allegoric Alaskans;Blithering Badgers;win
Devastating Donkeys;Courageous Californians;draw
Devastating Donkeys;Allegoric Alaskans;win
Courageous Californians;Blithering Badgers;loss
Blithering Badgers;Devastating Donkeys;loss
Allegoric Alaskans;Courageous Californians;win
INPUT
)

declare -A tally_array
declare -A team_array

while IFS= read -r line; do
    # IFS=';'; for word in $line; do 
    #     echo "$word"; 
    # done
    IFS=';'; tokens=( $line )
    __init_team "${tokens[0]}"
    __init_team "${tokens[1]}"

    echo "loop ${tokens[@]}"
    if [[ ${tokens[2]} == 'win' ]]; then
        ((tally_array["${tokens[0]}-win"]++))
        ((team_array["${tokens[0]}"]+=3))
    elif [[ ${tokens[2]} == 'loss' ]]; then
        ((tally_array["${tokens[1]}-win"]++))
        ((team_array["${tokens[1]}"]+=3))
    else        
        ((tally_array["${tokens[0]}-draw"]+=1))
        ((tally_array["${tokens[1]}-draw"]+=1))
        ((team_array["${tokens[0]}"]+=1))
        ((team_array["${tokens[1]}"]+=1))
    fi

    # printf "%s\n" "${!tally_array[@]}" "${tally_array[@]}" | pr -2t
done <<< "$input"

# echo "${!team_array[@]}"

# Team                           | MP |  W |  D |  L |  P
# Devastating Donkeys            |  3 |  2 |  1 |  0 |  7
# Allegoric Alaskans             |  3 |  2 |  0 |  1 |  6
# Blithering Badgers             |  3 |  1 |  0 |  2 |  3
# Courageous Californians        |  3 |  0 |  1 |  2 |  1

# https://www.cyberciti.biz/faq/bash-for-loop-array/
for i in "${!team_array[@]}"
do
    printf "%s\t\t|%s|\t|%s|\t|%s|\t|%s\n" "${i}" "${tally_array[$i-win]}" "${tally_array[$i-draw]}" "${tally_array[$i-loss]}" "${team_array[$i]}"
    # echo "$i"
done | sort -rn -k3

# echo ${input}
}

# https://linuxize.com/post/bash-functions/
__init_team(){
    # echo "$1"
    if [[ -z ${team_array[$1]} ]]; then
        # echo "adding $1"
        team_array[$1]=0
        tally_array["$1-win"]=0
        tally_array["$1-loss"]=0
        tally_array["$1-draw"]=0
    fi
}
main "$@"
