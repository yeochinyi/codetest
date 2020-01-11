package raindrops

import "strconv"

// Convert return Raindrops sound string if number matches
func Convert(input int) string {

	// Cannot use map here as it is unordered
	sounds := []struct {
		number int
		sound  string
	}{
		{3, "Pling"},
		{5, "Plang"},
		{7, "Plong"},
	}

	var ret string
	for _, v := range sounds {
		if input%v.number == 0 {
			ret += v.sound
		}
	}

	if ret == "" {
		return strconv.Itoa(input)
	}
	return ret

}
