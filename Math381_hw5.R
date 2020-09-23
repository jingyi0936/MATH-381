#set.seed(123)

numberOfGames = 100000
bigSum = 0

for (i in 1:numberOfGames) {
  sum = 0
  rollCount = 0
  while(sum < 20){
    rollCount <- rollCount + 1
    roll <- floor(runif(1, min = 1, max = 6))
    # print(roll)
    if(sum%%roll == 0){
      sum = roll + sum
    }else{
      sum = sum - roll
      if(sum < 0 ){
        sum = 0
      } 
    }
    
  }
  bigSum = bigSum + rollCount
}
print(bigSum/numberOfGames)
