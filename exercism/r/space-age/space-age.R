
# Return Earth age in years for each planet duration


space_age_1 <- function(seconds, planet) {
    earthYearSec <- 31557600
    if(planet == 'earth') factor = 1
    else if(planet == 'mercury') factor = 0.2408467
    else if(planet == 'venus') factor = 0.61519726
    else if(planet == 'mars') factor = 1.8808158
    else if(planet == 'jupiter') factor = 11.862615
    else if(planet == 'saturn') factor = 29.447498
    else if(planet == 'uranus') factor = 84.016846
    else if(planet == 'neptune') factor = 164.79132
    round(seconds /  factor / earthYearSec, digits=2)
}


# https://www.programcreek.com/2014/01/vector-array-list-and-data-frame-in-r/

space_age <- function(seconds, planet) {
  if(!is.character(planet)) stop ("Please enter a planet name as a string")
    
  earth_year = 31557600
  planet_conversions = c("earth" = 1, "mercury" = 0.2408467, "venus" = 0.61519726,
                          "mars" = 1.8808158, "jupiter" = 11.862615, "saturn" = 29.447498,
                          "uranus" = 84.016846,"neptune" = 164.79132)
  conv_factor<-unname(planet_conversions[planet])
  #browser()
  age<-round(seconds/(earth_year*conv_factor), 2)
  age
}

# planets <- data.frame(
#   secondsOfYear = c(1, 0.2408467, 0.61519726, 1.8808158, 11.862615, 29.447498, 84.016846, 164.79132) * e,
#   row.names = c("earth", "mercury", "venus", "mars", "jupiter", "saturn", "uranus", "neptune"))

# space_age <- function(seconds, planet) {
#   round(seconds / planets[planet, "secondsOfYear"], 2)
# }

# space_age <- function(seconds, planet) {

#     get <- function(planet) {
#     switch(planet,
#            "mercury" = 0.2408467,
#            "venus"   = 0.61519726,
#            "earth"   = 1,
#            "mars"    = 1.8808158,
#            "jupiter" = 11.862615,
#            "saturn"  = 29.447498,
#            "uranus"  = 84.016846,
#            "neptune" = 164.79132)
#   }
  
#   round(seconds / (31557600 * get(planet)), 2)

# }
# quick test using cli i.e Rscript .\space_age.R 2000
# args <- commandArgs(trailingOnly=TRUE)
# paste0("args=", args)
# space_age(as.numeric(args[1]), args[2])