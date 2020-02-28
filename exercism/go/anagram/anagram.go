package anagram

import (
	"reflect"
	"strings"
)

// Detect returns filtered list if anagram
func Detect(subject string, candidates []string) (ret []string) {

	subjectLower := strings.ToLower(subject)
	subMap := ToCountMap(subjectLower)
	for _, c := range candidates {
		cLower := strings.ToLower(c)
		if subjectLower != cLower && reflect.DeepEqual(subMap, ToCountMap(cLower)) {
			ret = append(ret, c)
		}
	}

	return ret
}

// ToCountMap returns counting map of rune
func ToCountMap(s string) map[rune]int {
	subMap := make(map[rune]int)
	for _, ch := range s {
		subMap[ch] = subMap[ch] + 1
	}
	return subMap
}
