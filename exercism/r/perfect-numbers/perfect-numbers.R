# returns perfect, abundant, or deficient depending on n
number_type <- function(n){
    if(n == 1) return ("deficient")
    vec <- 1:(n-1)
    total <- sum(vec[n%%vec==0])
    if(total == n) "perfect"
    else if(total > n) "abundant"
    else "deficient"
}