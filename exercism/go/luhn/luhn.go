package luhn

import (
	"regexp"
	"strconv"
	"strings"
)

func Valid(id string) bool {
	id = strings.ReplaceAll(id, " ", "")
	match, _ := regexp.MatchString("^\\d+$", id)
	if !match {
		return false
	}
	if len(id) < 2 {
		return false
	}
	sum := 0
	sp := strings.Split(id, "")
	for i := len(sp) - 1; i >= 0; i-- {
		n, _ := strconv.Atoi(sp[i])
		if (len(sp)-1-i)%2 == 1 {
			n *= 2
			if n > 9 {
				n -= 9
			}
		}
		sum += n
	}
	//fmt.Printf("test=%s, %d\n", id, sum)
	return sum%10 == 0
}
