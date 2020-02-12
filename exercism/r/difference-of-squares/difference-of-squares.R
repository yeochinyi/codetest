# https://stackoverflow.com/questions/5738831/r-plus-equals-and-plus-plus-equivalent-from-c-c-java-etc 
`%+=%` = function(e1,e2) eval.parent(substitute(e1 <- e1 + e2))

# Return diff of square of sum and sum of sequare
difference_of_squares <- function(natural_number) {
    # sq_sum <- 0
    # sum_sq <- 0
    # for (v in seq(1, natural_number)){
    # #    sq_sum <- sq_sum + v
    #    sq_sum %+=% v    
    #    sum_sq %+=% (v ^ 2)
    # }
    # sq_sum ^ 2 - sum_sq

    vec<-1:natural_number
    sum(vec)^2 - sum(vec^2)
}

# quick test using cli i.e Rscript .\difference-of-squares.R 10
# args <- commandArgs(trailingOnly=TRUE)
# paste0("args=", args)
# difference_of_squares(as.numeric(args[1]))
