A <- matrix(0, nrow = 21, ncol = 21)
count = 0
for (i in 0:14) {
  for (j in 1:6) {
    if(i%%j == 0){
      A[i + 1, i + j + 1] = 1/6
    }else{
      if(i - j <0){
        A[i+1, 1] = A[i+1, 1] + 1/6
      }else{
        A[i+1, i - j+1] = 1/6
      }
    }
  }
}
for(i in 15:20){
  for(j in 1:6){
    if(i + j >= 20){
      if(i%%j == 0){
        A[i+1, 21] = A[i+1, 21] + 1/6
      }else{
        A[i, i - j] = 1/6
      }
    }else{
      if(i%%j == 0){
        A[i, i + j] == 1/6
      }else{
        A[i, i - j] = 1/6
      } 
    }
  }
}
A[21, 21] = 1