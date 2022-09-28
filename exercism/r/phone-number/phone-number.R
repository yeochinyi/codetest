library(stringr)

# https://stringr.tidyverse.org/articles/regular-expressions.html
parse_phone_number <- function(number_string) {
    phone <- str_extract_all(number_string, "\\d+")
    # https://stat.ethz.ch/R-manual/R-devel/library/base/html/paste.html
    phone <- paste(phone[[1]], collapse='')
    if(nchar(phone)<10 || nchar(phone)>11){
        return(NULL)
    }
    else if(nchar(phone)==11){
        # print(typeof(phone))
        first <- substr(phone, 1,1)
        # print(first)
        if(first == '1'){
            phone <- substr(phone, 2, nchar(phone))
        }
        else{
            return(NULL)
        }
    }
    first <- substr(phone, 1,1)
    fourth <- substr(phone, 4,4)
    if(first < 2 || fourth < 2){
        return(NULL)
    }
    return(phone)
}

# expect_equal(parse_phone_number("(223) 456-7890"), "2234567890")
# print(parse_phone_number("(223) 056-7890"))

