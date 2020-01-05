// Package triangle contains triangle utils
package triangle

import "math"

// Kind : type of Triangle
type Kind int

const (
	// NaT : not a triangle
	NaT = iota
	// Equ : equilateral
	Equ
	// Iso : isosceles
	Iso
	// Sca : scalene
	Sca
)

// KindFromSides returns type of triangle based on Kind
func KindFromSides(a, b, c float64) Kind {
	var k Kind

	switch {
	// For a shape to be a triangle at all,
	// all sides have to be of length > 0, and the
	// sum of the lengths of any two sides must be greater than or equal
	// to the length of the third side. See Triangle Inequality.
	case math.IsNaN(a) || math.IsNaN(b) || math.IsNaN(c):
	case math.IsInf(a, 1) || math.IsInf(b, 1) || math.IsInf(c, 1):
	case math.IsInf(a, -1) || math.IsInf(b, -1) || math.IsInf(c, -1):
	case a <= 0 || b <= 0 || c <= 0:
	case a+b < c || a+c < b || b+c < a:
		k = NaT
	// 	An equilateral triangle has all three sides the same length.
	case a == b && b == c:
		k = Equ
	// An isosceles triangle has at least two sides the same length. (It is sometimes specified as having exactly two sides the same length, but for the purposes of this exercise we'll say at least two.)
	case a == b || b == c || a == c:
		k = Iso
	// A scalene triangle has all sides of different lengths.
	default:
		k = Sca
	}

	return k
}
