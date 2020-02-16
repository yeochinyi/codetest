package isogram

import (
	"unicode"
)

// IsIsogram returns true is isogram
func IsIsogram(input string) bool {

	// https://stackoverflow.com/questions/9251234/go-append-if-unique
	m := make(map[rune]struct{})
	emptyVal := struct{}{}

	for _, ch := range input {
		if ch == ' ' || ch == '-' {
			continue
		}
		lowerCh := unicode.ToLower(ch)
		_, exist := m[lowerCh]
		if exist {
			return false
		}
		m[lowerCh] = emptyVal
	}
	return true
}
