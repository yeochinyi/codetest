package protein

import "errors"

// ErrStop : stop protein
var ErrStop = errors.New("Encountered STOP protein")

// ErrInvalidBase : invalid string
var ErrInvalidBase = errors.New("Encountered invalid base")

// var (
// 	// ErrStop : stop protein
// 	ErrStop = constError("ErrStop")

// 	// ErrInvalidBase : invalid string
// 	ErrInvalidBase = constError("ErrInvalidBase")
// )

// // for creation of const Error string
// type constError string

// func (err constError) Error() string {
// 	return string(err)
// }

// FromCodon translate condon to protein
func FromCodon(input string) (output string, e error) {
	switch input {
	case "AUG":
		return "Methionine", nil
	case "UUU", "UUC":
		return "Phenylalanine", nil
	case "UUA", "UUG":
		return "Leucine", nil
	case "UCU", "UCC", "UCA", "UCG":
		return "Serine", nil
	case "UAU", "UAC":
		return "Tyrosine", nil
	case "UGU", "UGC":
		return "Cysteine", nil
	case "UGG":
		return "Tryptophan", nil
	case "UAA", "UAG", "UGA":
		return "", ErrStop
	default:
		return "", ErrInvalidBase
	}
}

// FromRNA translate condon combo to protein array
func FromRNA(input string) ([]string, error) {
	var output []string
	for i := 0; i < len(input); i += 3 {
		c, err := FromCodon(input[i : i+3])
		if err != nil {
			if err == ErrStop {
				err = nil
			}
			return output, err
		}
		output = append(output, c)
	}

	return output, nil
}
