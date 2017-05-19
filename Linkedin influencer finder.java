/*
Influencer Finder
public interface InfluencerFinder { 

/** 
* Given a matrix of following between N LinkedIn users (with ids from 0 to N-1): 
* followingMatrix[i][j] == true iff user i is following user j 
* thus followingMatrix[i][j] doesn't imply followingMatrix[j][i]. 
* Let's also agree that followingMatrix[i][i] == false 
* 
* Influencer is a user who is: 
* - followed by everyone else and 
* - not following anyone himself 
* 
* This method should find an Influencer by a given matrix of following, 
* or return -1 if there is no Influencer in this group. 
*/ 
int getInfluencer(boolean[][] followingMatrix)
*/


public int getInfluencer (int[][] matrix) {
  int candidate = 0;
  for (int i = 1; i < matrix.length; i++) {
    if (matrix[candidate][i] || !matrix[i][candiate]) {
      candiate = i;
    }
  }
  for (int i = 0; i < matrix.length; i++) {
    if (matrix[candiate][i] || !matrix[i][candidate]) {
      candidate = -1;
      return candidate;
    }
  }
  return candidate;
}
