package accumulate

// Accumulate return results of functional accumulate
func Accumulate(given []string, converter func(string) string) (ret []string) {
	for _, v := range given {
		ret = append(ret, converter(v))
	}
	return
}
