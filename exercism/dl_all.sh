#set -x
exer_ws=$(exercism workspace)
tmp_file="$HOME/tmp/exercism/exercises-$1.html"
wget "https://exercism.io/tracks/$1/exercises" -O $tmp_file --no-check-certificate
list=$(rg "/tracks/([\w\-]+)/exercises/([\w\-]+)" $tmp_file -o -r '$2' -N)
#echo $list
num_skip=0
num_dl_ok=0
num_dl_fail=0
for exer in $list; do
    exer_dir="$exer_ws/$1/$exer"
    echo checking $exer
    if [ ! -d "$exer_dir" ]; then 
        exercism download --exercise=$exer --track=$1
        echo exit_code=$?
        if [[ $? -eq 0 ]]; then
            echo downloaded $exer
            (( num_dl_ok +=1 ))
        else
            echo dl fail $exer
            (( num_dl_fail +=1 ))
        fi
    else
        (( num_skip +=1 ))
    fi
done
echo num_skip=$num_skip, num_dl_ok=$num_dl_ok, num_dl_fail=$num_dl_fail
