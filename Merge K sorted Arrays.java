class Node {
    int rowNum;
    int val;
    int colNum;
    Node (int val, int rowNum, int colNum) {
        this.val = val;
        this.rowNum = rowNum;
        this.colNum = colNum;
    }
}
public int[] mergeKSortedArray(int[][] arr) {
        
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>(){
             public int compare (Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });
        
        int totalLen = 0;
        //put first col of each array into heap
        for (int i = 0; i < arr.length; i++) {
            totalLen += arr[i].length;
            if (arr[i] != null && arr[i].length != 0) {
                Node cur = new Node(arr[i][0], i, 0);
                heap.offer(cur);
            }
        }
        
        int[] result = new int[totalLen];
        int index = 0;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int row = cur.rowNum;
            int col = cur.colNum;
            if (col + 1 < arr[row].length) {
                heap.offer(new Node(arr[row][col + 1], row, col + 1));
            }

            result[index++] = cur.val;
        }
    
        return result;
    }
