public int[][] printBoard (int n, int candy) {
  int[][] board = new int[n][n];
  Random rand = new Random();
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      Set<Integer> visited = new HashSet<>();
      while (true) {
        board[i][j] = rand.nextInt(candy);
        if (!visited.contains(board[i][j])) {
          visited.add(board[i][j]);
          if (isValid(board, i, j)) {
            break;
          }
        }
      }
    }
  }
  return board;
}
public boolean isValid (int[][] board, int row, int col) {
  if (row - 2 >= 0) {
    if (board[row - 1][col] == board[row][col] && board[row - 2][col] == board[row][col]) {
      return false;
    }
  }
  if (col - 2 >= 0) {
    if ((board[row][col - 1] == board[row][col]) && (board[row][col - 2] == board[row][col])) {
      return false;
    }
  }
  return true;
}
