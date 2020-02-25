package pangram

import (
	"regexp"
	"strings"
)

// IsPangram returns is input is a pangram
func IsPangram(input string) bool {

	set := make(map[rune]bool)

	r, _ := regexp.Compile("[a-z]")

	for _, ch := range strings.ToLower(input) {
		if r.MatchString(string(ch)) {
			set[ch] = true
		}
	}

	return len(set) == 26
}
