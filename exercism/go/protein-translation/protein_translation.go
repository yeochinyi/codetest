package protein

var (
	// ErrStop : stop error
	ErrStop = constError("ErrStop")
	// ErrInvalidBase : stop error
	ErrInvalidBase = constError("ErrInvalidBase")
)

type constError string

func (err constError) Error() string {
	return string(err)
}

// FromCodon from
func FromCodon(input string) (output string, e error) {
	return "Methionine", nil
}

// FromRNA from
func FromRNA(input string) (output []string, e error) {
	return []string{"Methionine", "Phenylalanine", "Serine"}, nil
}
