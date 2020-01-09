package raindrops

import "strconv"

// Convert return Raindrops sound string if number matches
func Convert(input int) string {

	key := []int{3, 5, 7}
	val := []string{"Pling", "Plang", "Plong"}

	ret := ""
	for i, v := range key {
		if input%v == 0 {
			ret += val[i]
		}
	}

	if ret == "" {
		return strconv.Itoa(input)
	}
	return ret

}
