package complex

import "math"

// Define the Number type here.
type Number struct {
	a float64
	b float64
}

func (n Number) Real() float64 {
	return n.a
}

func (n Number) Imaginary() float64 {
	return n.b
}

func (n1 Number) Add(n2 Number) Number {
	return Number{n1.a + n2.a, n1.b + n2.b}
}

func (n1 Number) Subtract(n2 Number) Number {
	return Number{n1.a - n2.a, n1.b - n2.b}
}

func (n1 Number) Multiply(n2 Number) Number {
	return Number{n1.a*n2.a - n1.b*n2.b, n1.a*n2.b + n1.b*n2.a}
}

func (n Number) Times(factor float64) Number {
	return Number{n.a * factor, n.b * factor}
}

func (n1 Number) Divide(n2 Number) Number {
	d := math.Pow(n2.a, 2) + math.Pow(n2.b, 2)
	return Number{(n1.a*n2.a + n1.b*n2.b) / d, (-n1.a*n2.b + n1.b*n2.a) / d}
}

func (n Number) Conjugate() Number {
	return Number{n.a, -n.b}
}

func (n Number) Abs() float64 {
	return math.Sqrt(math.Pow(n.a, 2) + math.Pow(n.b, 2))
}

func (n Number) Exp() Number {
	exp_a := math.Exp(n.a)
	return Number{exp_a * math.Cos(n.b), exp_a * math.Sin(n.b)}
}
