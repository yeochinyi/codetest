// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

/*
Package twofer implements simple library for exercism
*/
// https://golang.org/doc/effective_go.html#commentary
package twofer

import "fmt"

// ShareWith return hardcoded message depends on name
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}
	return fmt.Sprintf("One for %v, one for me.", name)
}
