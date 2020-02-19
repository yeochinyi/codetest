collatz_step_counter <- function(num) {
    # if(is.vector(num)){
    #     r <- c()
    #     for (v in num){
    #         r = append(collatz_single(v), r, 0)
    #     }
    #     return(r)
    # }
    # else{
    #     return (collatz_single(num))
    # }
    return (sapply(num, collatz_single))
}

collatz_single <- function(num){
   if(num < 1) error ("num invalid")
   step = 0
   while(num != 1){
       step = step + 1
    if(num %% 2 == 0){
        num = num / 2
    }
    else{
        num = num * 3 +1
    }
   }
   step
}

# print(collatz_step_counter(c(12,12)))