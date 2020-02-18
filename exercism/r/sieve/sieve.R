  # https://jamesmccaffrey.wordpress.com/2016/05/02/r-language-vectors-vs-arrays-vs-lists-vs-matrices-vs-data-frames/

sieve <- function(limit) {
  if(limit < 2){
    return(c())
  }
  if(limit == 2){
    return(2)
  }
  vec <- 2:limit
  # print(vec)
  len <- length(vec)
  # cat("len=",len,"vec=",vec,"\n")
  logVec <- vector(mode="logical", len)
  # print(logVec)
  for(x in 1:(len-1)){    
    if(logVec[x]){
      # print("skip")
      next
    }
    for(y in (x+1):len){
      # cat("vec y",y,"->",vec[y],"\n")
      # cat("vec x",x,"->",vec[x],"\n")
      if(vec[y] %% vec[x] == 0){
        logVec[y]=TRUE
        # print(logVec)
      }
    }        
  }  
  vec[!logVec]
}

sieve(2)