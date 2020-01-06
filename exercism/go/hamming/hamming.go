package hamming

import "errors"

// Distance return hamming difference b/w 2 strings
func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		// Prefer errors.New over fmt.Errorf for error messages that don't need interpolation, as it avoids parsing the message for placeholders.
		return 0, errors.New("a, b is not same len")
	}

	diff := 0
	for i, r := range a {
		if r != rune(b[i]) {
			diff++
		}
	}

	return diff, nil
}
