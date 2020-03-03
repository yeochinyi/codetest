package wordcount

import (
	"regexp"
	"strings"
)

// Frequency is counter of word
type Frequency map[string]int

// WordCount returns Frequency object of string vs count
func WordCount(text string) Frequency {
	text = regexp.MustCompile(`[!@$%^&:]`).ReplaceAllLiteralString(text, "")
	text = strings.ToLower(text)
	f := Frequency{}
	// words := strings.FieldsFunc(strings.ToLower(sentence), func(c rune) bool {
	// 	return !unicode.IsLetter(c) && !unicode.IsNumber(c) && c != '\''
	// })
	// wordMatch := regexp.MustCompile("(?:[\"'])?([a-zA-Z0-9]+('[a-zA-Z0-9])?)(?:[\"'])?")
	// aaa := wordMatch.FindAllStringSubmatch(phrase,-1)
	for _, v := range strings.FieldsFunc(text, func(r rune) bool {
		return r == ' ' || r == ',' || r == '\n' || r == '\t' || r == '.'
	}) {
		// v = regexp.MustCompile(`^'(.*)'$`).ReplaceAllString(v, "$1")
		v = strings.Trim(v, "'")
		f[v]++
	}

	return f
}
