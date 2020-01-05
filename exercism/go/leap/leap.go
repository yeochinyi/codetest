// Package leap provide leap year utils
package leap

// IsLeapYear returns if input year is leap
// 	on every year that is evenly divisible by 4
//  except every year that is evenly divisible by 100
//  unless the year is also evenly divisible by 400
// For example, 1997 is not a leap year, but 1996 is. 1900 is not a leap year, but 2000 is.
func IsLeapYear(year int) bool {

	switch {
	case year%400 == 0:
		return true
	case year%100 == 0:
		return false
	case year%4 == 0:
		return true
	}

	return false
}
