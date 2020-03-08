package encode

import (
	"strconv"
	"strings"
	"unicode"
)

// RunLengthEncode encodes text
func RunLengthEncode(text string) string {
	if text == "" {
		return ""
	}
	output := ""
	var counter int = 0
	var lastChar string = ""

	GenString := func(counter int, lastChar string) string {
		num := ""
		if counter != 1 {
			num = strconv.Itoa(counter)
		}
		return num + lastChar
	}

	for _, c := range text {
		r := string(c)
		if lastChar == "" || lastChar == r {
			counter++
		} else {
			output = output + GenString(counter, lastChar)
			counter = 1
		}
		lastChar = r
	}

	return output + GenString(counter, lastChar)
}

// RunLengthDecode decodes text
func RunLengthDecode(text string) string {
	output := ""
	numString := ""
	for _, c := range text {
		r := string(c)
		if unicode.IsDigit(c) {
			numString += r
		} else {
			num, _ := strconv.Atoi(numString)
			if num > 1 {
				output = output + strings.Repeat(r, num)
			} else {
				output = output + r
			}
			numString = ""
		}

	}
	return output
}
