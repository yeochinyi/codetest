// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package acronym should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package acronym

import (
	"regexp"
	"strings"
)

// Abbreviate should have a comment documenting it.
func AbbreviateBak(s string) string {
	t := strings.FieldsFunc(s, Split)
	//t := strings.Split(s, " ")
	r := ""
	for _, j := range t {
		re, _ := regexp.Compile(`[_]`)
		j = re.ReplaceAllString(j, " ")
		r = r + strings.ToUpper(j[0:1])
	}
	return r
}
func Split(r rune) bool {
	return r == '-' || r == ' '
}

func Abbreviate(s string) string {
	re := regexp.MustCompile(`[\PL]*([\pL])[\pL']*[\PL]*`)
	output := re.ReplaceAllString(s, "$1")
	return strings.ToUpper(output)
}
