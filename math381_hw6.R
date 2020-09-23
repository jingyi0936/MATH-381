buffoneedle <- function(n, L, a){
  hit = 0
  for(i in 1:n) {
    x <- runif(1, 0, 1)
    y <- runif(1, 0, 1)
    while(x^2 + y^2 > 1) { # no points outside of unit circle
      x <- runif(1, 0, 1)
      y <- runif(1, 0, 1)
    }	
    theta <- atan(y/x) # the random angle
    d <- runif(1, 0, (L/2)) # distance of needle midpoint to nearest line
    if(d <= (a/2)*sin(theta)) {
      hit <- hit + 1
    } 
  }
  prob = hit/n
}
numGame = 1000
ans <- rep(0, numGame)
for(i in 1:numGame){
  ans[i] <- buffoneedle(10000, 1, 0.8)
}
hist(ans, breaks = 50, xlab = "probability", main = "Histogram of probability")
mean <- rep(0, numGame)
for(i in 1:numGame){
  mean[i] = mean(ans[0:i])
}
plot(c(1:1000), mean, xlab = "Trials", ylab = "Probablity",
     main = "Trials vs Probability", type = "l")
lines(c(1:1000), mean)