package scrabble

import "strings"

// Score return total scrabble score of the word
func Score(s string) int {

	initialScoreMap := map[string]int{
		"AEIOULNRST": 1,
		"DG":         2,
		"BCMP":       3,
		"FHVWY":      4,
		"K":          5,
		"JX":         8,
		"QZ":         10,
	}

	scoreMap := make(map[rune]int)

	for k, v := range initialScoreMap {
		for _, r := range k {
			scoreMap[r] = v
		}
	}

	total := 0
	for _, r := range strings.ToUpper(s) {
		total += scoreMap[r]
	}

	return total
}
