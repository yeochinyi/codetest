raindrops <- function(number) {
    num <- c(3,5,7)
    sound <- c('Pling', 'Plang', 'Plong')
    bools <- sapply(num, function(it){number %% it == 0})
    val <- paste(sound[bools], collapse='')
    if(val == ''){
        return (toString(number))
    }
    val    
}