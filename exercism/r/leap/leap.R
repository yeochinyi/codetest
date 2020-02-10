
leap <- function(year) {
    return (year%%400 == 0 | (year%%4 == 0 & year%%100 != 0))
}

# quick test using cli i.e Rscript .\leap.R 2000
# args <- commandArgs(trailingOnly=TRUE)
# paste0("args=", args)
# leap(as.numeric(args[1]))
