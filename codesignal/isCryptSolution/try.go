package try

import (
	"errors"
	"strconv"
)

func isCryptSolution(crypt []string, solution [][]string) bool {
	solMap := make(map[string]string)
	for _, i := range solution {
		solMap[i[0]] = i[1]
	}

	vals := make([]int, 3)
	var e error
	for i := 0; i < 3; i++ {
		vals[i], _ = convert(crypt[i], solMap)
		if e != nil {
			return false
		}
		// fmt.Printf("%v = %v\n", i, vals[i])
	}

	return vals[0]+vals[1] == vals[2]

}

func convert(phrase string, solMap map[string]string) (int, error) {
	var ret string
	for _, ch := range phrase {
		ret += solMap[string(ch)]
	}

	if len(ret) > 1 && ret[0] == '0' {
		return -1, errors.New("Invalid")
	}

	return strconv.Atoi(ret)
}
