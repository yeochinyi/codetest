package space

// Planet : planets of SOL
type Planet string

// Age returns:
// Given an age in seconds, calculate how old someone would be on
// orbital period in Earth years
func Age(sec float64, planet Planet) float64 {
	earthYear := sec / 31557600
	var orbitalAge float64
	switch planet {
	case "Mercury": //orbital period 0.2408467 Earth years
		orbitalAge = earthYear / 0.2408467
	case "Venus": //orbital period 0.61519726 Earth years
		orbitalAge = earthYear / 0.61519726
	case "Earth": //orbital period 1.0 Earth years, 365.25 Earth days, or 31557600 seconds
		orbitalAge = earthYear
	case "Mars": //orbital period 1.8808158 Earth years
		orbitalAge = earthYear / 1.8808158
	case "Jupiter": //orbital period 11.862615 Earth years
		orbitalAge = earthYear / 11.862615
	case "Saturn": //orbital period 29.447498 Earth years
		orbitalAge = earthYear / 29.447498
	case "Uranus": //orbital period 84.016846 Earth years
		orbitalAge = earthYear / 84.016846
	case "Neptune": //orbital period 164.79132 Earth years
		orbitalAge = earthYear / 164.79132
	}
	return orbitalAge
}
