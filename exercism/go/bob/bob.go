package bob

import (
	"regexp"
	"strings"
)

func Hey(remark string) string {
	remark = strings.TrimSpace(remark)
	isQuestion, _ := regexp.MatchString("^.*\\?$", remark)
	isYelling, _ := regexp.MatchString("^[A-Z\\d\\s[:punct:]]+[A-Z][A-Z\\d\\s[:punct:]]+$", remark)
	switch {
	case isQuestion && isYelling:
		return "Calm down, I know what I'm doing!"
	case isQuestion:
		return "Sure."
	case isYelling:
		return "Whoa, chill out!"
	case remark == "":
		return "Fine. Be that way!"
	default:
		return "Whatever."
	}
}
