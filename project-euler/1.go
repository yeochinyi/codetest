package main

import "fmt"

func main() {

	//multis  := []int{3,5}
	r := getNaturalNum(1000, []int{3, 5})
	fmt.Println(r)
	sum := 0
	for _, v := range r {
		sum += v
	}
	fmt.Println(sum)
}

func getNaturalNum(n int, multis []int) []int {

	//fmt.Println(multis)

	var ret []int

	for i := 1; i < n; i++ {
		for _, j := range multis {
			//fmt.Println(i, j)

			if i%j == 0 {
				ret = append(ret, i)
				break
			}
		}
	}

	return ret
}
