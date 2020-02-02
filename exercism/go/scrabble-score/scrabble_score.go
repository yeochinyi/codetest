package scrabble

import "strings"

// Score return total scrabble score of the word
func Score(s string) int {

	total := 0
	var inc int
	for _, r := range strings.ToUpper(s) {
		switch r {
		case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T':
			inc = 1
		case 'D', 'G':
			inc = 2
		case 'B', 'C', 'M', 'P':
			inc = 3
		case 'F', 'H', 'V', 'W', 'Y':
			inc = 4
		case 'K':
			inc = 5
		case 'J', 'X':
			inc = 8
		case 'Q', 'Z':
			inc = 10
		}
		total += inc
	}

	return total
}
