package scrabble

import "strings"

var initialScoreMap = map[string]int{
	"AEIOULNRST": 1,
	"DG":         2,
	"BCMP":       3,
	"FHVWY":      4,
	"K":          5,
	"JX":         8,
	"QZ":         10,
}

var scoreMap = make(map[rune]int)

func init() {
	for k, v := range initialScoreMap {
		for _, r := range k {
			scoreMap[r] = v
		}
	}
}

// Score return total scrabble score of the word
func Score(s string) int {

	total := 0
	for _, r := range strings.ToUpper(s) {
		total += scoreMap[r]
	}

	return total
}
