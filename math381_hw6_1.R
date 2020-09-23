N = 1000;
prop <- rep(0, N);
for(j in 1:N){  
  n = 10000
  cross = 0;
  for(k in 1:n){ 
    center.x = runif(1, 0, 6);
    center.y = runif(1, 0, 6);
    
    pt.x = c(0, 0, 0);
    alpha = runif(1, 0, 2*pi/3);
    l = 0.8*sqrt(3)/3;
    pt.x[1] = center.x + l*cos(alpha);
    pt.x[2] = center.x + l*cos(2*pi/3+alpha);
    pt.x[3] = center.x + l*cos(4*pi/3+alpha);
    if(floor(pt.x[1]) != floor(pt.x[2]) | floor(pt.x[1]) != floor(pt.x[3]) | floor(pt.x[3]) != floor(pt.x[2])){
      cross = cross + 1;
    }
  }
  prop[j] = cross/n;
}
mean <- rep(0, N)
for(i in 1:N){
  mean[i] = mean(prop[0:i])
}

plot(c(1:1000), mean, xlab = "Trials", ylab = "Probablity",
     main = "Trials vs Probability", type = "l")
lines(c(1:1000), mean)
