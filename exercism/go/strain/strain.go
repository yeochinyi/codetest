package strain

type Ints []int
type Lists [][]int
type Strings []string

// Keep return Ints with f predicate true
func (ints Ints) Keep(f func(int) bool) Ints {
	var ret Ints
	for _, i := range ints {
		if f(i) {
			ret = append(ret, i)
		}
	}
	return ret
}

// Discard return Ints with f predicate false
func (ints Ints) Discard(f func(int) bool) Ints {
	var ret Ints
	for _, i := range ints {
		if !f(i) {
			ret = append(ret, i)
		}
	}
	return ret
}

// Keep return Lists with f predicate true
func (lists Lists) Keep(f func([]int) bool) Lists {
	var ret Lists
	for _, i := range lists {
		if f(i) {
			ret = append(ret, i)
		}
	}
	return ret
}

// Keep return Strings with f predicate true
func (strings Strings) Keep(f func(string) bool) Strings {
	var ret Strings
	for _, i := range strings {
		if f(i) {
			ret = append(ret, i)
		}
	}
	return ret
}
