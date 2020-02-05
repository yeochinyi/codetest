package etl

import "strings"

// Transform return return newMap data given oldMap data
func Transform(oldMap map[int][]string) map[string]int {
	newMap := make(map[string]int)
	for k, v := range oldMap {
		for _, letter := range v {
			l := strings.ToLower(letter)
			newMap[l] = k
		}
	}
	return newMap
}
