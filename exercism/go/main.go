package main

import (
	"fmt"

	"main/etl"
	// "main/morestrings"
	// "github.com/google/go-cmp/cmp"
)

// https://golang.org/doc/code.html
func main() {
	// fmt.Println(morestrings.ReverseRunes("!oG ,olleH"))
	// fmt.Println(morestrings.Test())
	// fmt.Println(cmp.Diff("Hello World", "Hello Go"))
	fmt.Println(etl.Transform(map[int][]string{1: {"A"}}))
}
