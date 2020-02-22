package isogram

import (
	"unicode"
)

// IsIsogram returns true is isogram
func IsIsogram(input string) bool {

	// https://stackoverflow.com/questions/9251234/go-append-if-unique
	m := make(map[rune]bool)
	// emptyVal := struct{}{}

	for _, ch := range input {
		if ch == ' ' || ch == '-' {
			continue
		}
		lowerCh := unicode.ToLower(ch)

		if m[lowerCh] {
			return false
		}
		m[lowerCh] = true
	}
	return true
}
