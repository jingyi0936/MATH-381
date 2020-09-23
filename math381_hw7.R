library(wordcloud)
library(scatterplot3d)

# read data set and add column/row names
dir = "C:/Users/cuijy/Desktop"
distance <- read.csv(file.path(dir, "data.csv"), header = F)
row.names(distance) <- c("Beijing", "Dali", "Shenzhen", "HK", 
                         "Urumqi", "Nanjing", "Suzhou", "Guilin", "Chongqing", "Wuhan")
colnames(distance) <- c("Beijing", "Dali", "Shenzhen", "HK", 
                        "Urumqi", "Nanjing", "Suzhou", "Guilin", "Chongqing", "Wuhan")

dist = as.matrix(distance)
hist(dist, breaks = 10, main = "Histogram of Original Distances", col = 4)

model1 <- cmdscale(dist, k = 1)
plot(model1, asp = 1)
hist(dist(model1), breaks = 10, main = "Histogram of MDS model, k = 1", col = 2)
par(pty="s")
plot(dist(model1), dist(distance), asp = 1)
# how good is this model
gof_val = cmdscale(dist, k = 1, eig = T)$GOF # 0.72, 0.723

eig_val = eigen(dist)
plot(eig_val$values, ylim = c(min(eig_val$values), 20000), main = "Eigenvalues")

plot(dist, as.matrix(dist(model1)))

model2 <- cmdscale(dist, k = 2)
plot(model2, asp = 1, xlim = c(-1100, 2400), ylim = c(-1020, 1300))
hist(dist(model2), breaks = 10, main = "Histogram of MDS model, k = 2", col = 3)
plot(dist(model2), dist(distance), asp = 1)
# how good is this model
gof_val_2 = cmdscale(dist, k = 2, eig = T)$GOF # 0.995, 0.999

model3 <- cmdscale(dist, k = 3)
plot(model3, asp = 1)
hist(dist(model3), breaks = 10, main = "Histogram of MDS model, k = 3", col = 1)
plot(dist(model3), dist(distance), asp = 1)
# how good is this model
gof_val_3 = cmdscale(dist, k = 3, eig = T)$GOF # 0.996, 1

GOF <- c(gof_val[1], gof_val_2[1], gof_val_3[1])
plot(c(1, 2, 3), GOF, ylim = c(0.6, 1.2), col = 6, main = "GOF vs Dimension", 
     xlab = "Dimension")

text(-model2[,1],model2[,2],c("Beijing", "Dali", "Shenzhen", "HK", 
                              "Urumqi", "Nanjing", "Suzhou", "Guilin", 
                              "Chongqing", "Wuhan"), cex=.7)
plot(-model2[,1], model2[,2]) 
table = dist(model2)-as.dist(distance)
scatterplot3d(model3)