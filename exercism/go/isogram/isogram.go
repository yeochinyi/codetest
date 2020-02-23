package isogram

import (
	"unicode"
)

// IsIsogram returns true is isogram
func IsIsogram(input string) bool {

	m := make(map[rune]bool)

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
