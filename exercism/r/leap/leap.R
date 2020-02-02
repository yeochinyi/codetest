
leap <- function(year) {
    if(year%%400 == 0){
        return (TRUE)
    }
    if(year%%100 == 0){
        return (FALSE)
    }
    if(year%%4 == 0){
        return (TRUE)
    }
    return (FALSE)
    # Alternative
    # x <- if(year%%400 == 0) TRUE else if(year%%100 == 0) FALSE else if(year%%4 == 0) TRUE else FALSE
    # return (x)
}

# quick test using cli i.e Rscript .\leap.R 2000
# args <- commandArgs(trailingOnly=TRUE)
# paste0("args=", args)
# leap(as.numeric(args[1]))
