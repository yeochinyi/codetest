// Package weather should have comments.
package weather

// CurrentCondition also should have comments.
var CurrentCondition string

// CurrentLocation also should have comments.
var CurrentLocation string

// Forecast needs comments also!!!.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
