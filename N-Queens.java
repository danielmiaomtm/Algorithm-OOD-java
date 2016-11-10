class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        helper (result, list, n, 0);
        return result;
    }
    public void helper (ArrayList<ArrayList<String>> result, ArrayList<Integer> list, int n, int index) {
        if (index == n) {
            result.add(new ArrayList<>(drawBoard(list)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(list, i, index)) {
                list.add(i);
                helper (result, list, n, index + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isValid (ArrayList<Integer> list, int col, int row){
        for (int i = 0; i < list.size(); i++) {
        //if num exists in the vertical line
            if (list.get(i) == col) {
                return false;
            }
        // i means row num in list, list.get(i) means col num in list
            if (i + list.get(i) == row + col) {
                return false;
            }
        // num exists in the right dia
            if (i - list.get(i) == row - col) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> drawBoard (ArrayList<Integer> list) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size() - 1; j++) {
                sb.append('.');
            }
            sb.insert((int)list.get(i), 'Q');
            result.add(sb.toString());
        }
        return result;

    }
};
