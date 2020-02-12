square <- function(n) {
    if(n < 1 | n > 64){
        stop("Error")
    }
    2^(n - 1)
}

total <- function() {
    vec<-1:64
    sum(2^(vec-1))
    # sum(sapply(1:64, square))
}

# quick test using cli i.e Rscript .\difference-of-squares.R 10
# args <- commandArgs(trailingOnly=TRUE)
# paste0("args=", args)
total()
