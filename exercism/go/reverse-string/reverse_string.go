package reverse

// Reverse returns reversed string of input
func Reverse(input string) string {
	var ret []rune
	for _, ch := range input {
		ret = append([]rune{ch}, ret...)
	}

	return string(ret)
}
