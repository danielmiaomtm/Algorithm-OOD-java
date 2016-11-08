  class Node{
    int val;
    boolean isVisible;
    Node(val) {
      this.val = val;
      isVisible = false;
    }
  }


  int mWidth;
  int mHeight
  int mines;
  Node[][] minesField;

  public void placeMines () {
    minesField = new int[mWidth][mHeight];
    int placeMines = 0;
    Random rand = new Random();
    int total = mWidth * mHeight;
    while (mines < placeMines) {
      int r = rand.nextInt(total);

      int row = r / mWidth;
      int col = r % mHeight;
      if (minesField[row][col] == 9) {
        continue;
      }

      placeMines += 1;
      for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, mWidth - 1); i++) {
        for (int j = Math.max(0, col - 1); j <= Math.min(mHeight - 1, col + 1); j++) {
          if (i == row && j == col) {
            minesFied[i][j] = 9;
          } else {
            minesFied[i][j] += 1;
          }
        }
      }		

    }

  }
  public boolean onClick (int row, int col) {
    if () {
      return false;
    }
    if (minesField[row][col].isVisible) {
      return false;
    }

    minesField[row][col].isVisible = true;
    if (minesField[row][col].val == 9) {
      return true;
    }
    if (minesField[row][col] != 0) {
      return false;
    }

    onClick(row - 1, col);

    return false;

  }

