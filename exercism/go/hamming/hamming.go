package hamming

import "fmt"

func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		return 0, fmt.Errorf("a, b is not same len.")
	}

	diff := 0
	for i, r := range a {
		if r != rune(b[i]) {
			diff++
		}
	}

	return diff, nil
}
