/*
给一排房子，用RGB三种颜色染色，相邻不能染成同色，每个房子染对应颜色会有对应的weight（W[N][3]），求最小的weight和
*/

public int minCost(int[][] costs) {
    if(costs==null||costs.length==0){
        return 0;
    }
    for(int i=1; i<costs.length; i++){
        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
    }
    int n = costs.length-1;
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
}


//n color

public int minCost (int[][] costs) {
  
  if(costs != null && costs.length == 0) return 0;
  
  int prevMin = 0, prevSec = 0, prevIdx = -1;
  
  for(int i = 0; i < costs.length; i++){
      int currMin = Integer.MAX_VALUE, currSec = Integer.MAX_VALUE, currIdx = -1;
      for(int j = 0; j < costs[0].length; j++){
          costs[i][j] += (prevIdx == j ? prevSec : prevMin);
          // 找出最小和次小的，最小的要记录下标，方便下一轮判断
          if(costs[i][j] < currMin){
              currSec = currMin;
              currMin = costs[i][j];
              currIdx = j;
          } else if (costs[i][j] < currSec){
              currSec = costs[i][j];
          }
      }
      prevMin = currMin;
      prevSec = currSec;
      prevIdx = currIdx;
  }
  int result = Integer.MAX_VALUE;
  for (int j = 0; j < colNum; j++) {
    result = Math.min(result, costs[rowNum - 1][j]);
  }
  return result;
    
  
}
