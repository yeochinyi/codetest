package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	m := map[string]int{
		"ace":   11,
		"eight": 8,
		"two":   2,
		"nine":  9,
		"three": 3,
		"ten":   10,
		"four":  4,
		"jack":  10,
		"five":  5,
		"queen": 10,
		"six":   6,
		"king":  10,
		"seven": 7,
		"other": 0,
	}
	return m[card]
}

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	if card1 == "ace" && card2 == "ace" {
		return "P"
	}
	sum := ParseCard(card1) + ParseCard(card2)
	//println("%d", sum)
	d := ParseCard(dealerCard)
	switch {
	case sum >= 17 && sum <= 20:
		return "S"
	case sum <= 11:
		return "H"
	case sum >= 12 && sum <= 16:
		if d >= 7 {
			return "H"
		} else {
			return "S"
		}
	case sum == 21:
		if d == 10 || d == 11 {
			return "S"
		} else {
			return "W"
		}

	}
	return "S"
}
