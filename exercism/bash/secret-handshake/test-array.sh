create_array() {
    local -n arr=$1              # use nameref for indirection
    arr=(one "two three" four)
}

use_array() {
    local my_array
    create_array my_array       # call function to populate the array
    echo "inside use_array"
    declare -p my_array         # test the array
}

use_array