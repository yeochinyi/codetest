package proverb

import "fmt"

// Proverb return a sample proverb based on the rhyme
func Proverb(rhyme []string) []string {

	var proverb []string

	if len(rhyme) == 0 {
		return proverb
	}

	for i := 0; i < len(rhyme)-1; i++ {
		s := fmt.Sprintf("For want of a %v the %v was lost.", rhyme[i], rhyme[i+1])
		proverb = append(proverb, s)
	}

	proverb = append(proverb, fmt.Sprintf("And all for the want of a %v.", rhyme[0]))

	return proverb
}
