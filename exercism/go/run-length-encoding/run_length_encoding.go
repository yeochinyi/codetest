package encode

import (
	"strconv"
	"strings"
	"unicode"
)

func GetStringOfCounter(counter int, lastChar string) string {
	num := ""
	if counter != 1 {
		num = strconv.Itoa(counter)
	}
	return num + lastChar
}

func RunLengthEncode(text string) string {
	if text == "" {
		return ""
	}
	output := ""
	var counter int = 0
	var lastChar string = ""

	for _, c := range text {
		r := string(c)
		if lastChar == "" || lastChar == r {
			counter++
		} else {
			output = output + GetStringOfCounter(counter, lastChar)
			counter = 1
		}
		lastChar = r
	}

	return output + GetStringOfCounter(counter, lastChar)
}

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
