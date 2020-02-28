raindrops <- function(number) {
    # num <- c(3,5,7)
    # sound <- c('Pling', 'Plang', 'Plong')
    # bools <- sapply(num, function(it){number %% it == 0})
    # val <- paste(sound[bools], collapse='')
    # if(val == ''){
    #     return (toString(number))
    # }
    # val    

    sounds <- list("Pling", "Plang", "Plong")
    mask <- c(number %% 3 == 0, number %% 5 == 0, number %% 7 == 0)
    ifelse(any(mask), do.call(paste0, sounds[mask]), as.character(number))
}