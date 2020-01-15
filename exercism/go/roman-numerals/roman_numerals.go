package romannumerals

import (
	"errors"
	"strings"
)

// ToRomanNumeral : convert arabic number to roman numbers
// return error if <1 or >3000

func ToRomanNumeral(arabic int) (string, error) {

	if arabic < 1 || arabic > 3000 {
		return "", errors.New("invalid")
	}

	romans := [][]string{
		{"I", "V", "X"},
		{"X", "L", "C"},
		{"C", "D", "M"},
		{"M", "", ""},
	}

	ret := ""
	counter := 0
	for {
		digit := arabic % 10
		var v string
		row := romans[counter]
		switch {
		case digit < 4:
			v = strings.Repeat(row[0], digit)
		case digit == 4:
			v = row[0] + row[1]
		case digit < 9:
			v = row[1] + strings.Repeat(row[0], digit-5)
		case digit == 9:
			v = row[0] + row[2]
		}
		ret = v + ret

		arabic /= 10
		counter++
		if arabic == 0 {
			break
		}
	}

	return ret, nil
}
