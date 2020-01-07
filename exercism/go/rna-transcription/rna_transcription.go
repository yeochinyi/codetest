package strand

// ToRNA swap DNA to RNA
func ToRNA(dna string) string {

	m := map[rune]rune{
		'G': 'C',
		'C': 'G',
		'T': 'A',
		'A': 'U',
	}
	var ret []rune
	for _, nucleotide := range dna {
		ret = append(ret, m[rune(nucleotide)])
	}

	return string(ret)
}
