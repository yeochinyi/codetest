package try

import "testing"

func TestTry(t *testing.T) {
	expected := true

	crypt := []string{"SEND", "MORE", "MONEY"}
	solution := [][]string{
		{"O", "0"},
		{"M", "1"},
		{"Y", "2"},
		{"E", "5"},
		{"N", "6"},
		{"D", "7"},
		{"R", "8"},
		{"S", "9"},
	}

	if observed := isCryptSolution(crypt, solution); observed != expected {
		t.Fatalf("HelloWorld() = %v, want %v", observed, expected)
	}
}
