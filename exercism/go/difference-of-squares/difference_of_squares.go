package diffsquares

import "math"

func SquareOfSum(input int) int {
	total := 0
	for i := 1; i <= input; i++ {
		total += i
	}
	return int(math.Pow(float64(total), 2))
}

func SumOfSquares(input int) int {
	total := 0.0
	for i := 1; i <= input; i++ {
		total += math.Pow(float64(i), 2)
	}
	return int(total)
}

func Difference(input int) int {
	return SquareOfSum(input) - SumOfSquares(input)
}
