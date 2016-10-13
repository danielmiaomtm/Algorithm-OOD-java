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
        
        int total = 0;
        //put first col
        for (int i = 0; i < arr.length; i++) {
            total += arr[i].length;
            if (arr[i] != null && arr[i].length != 0) {
                Node cur = new Node(arr[i][0], i, 0);
                heap.offer(cur);
            }
        }
        
        int[] result = new int[total];
        int index = 0;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int x = cur.rowNum;
            int y = cur.colNum;
            if (y + 1 < arr[x].length) {
                heap.offer(new Node(arr[x][y + 1], x, y + 1));
            }

            result[index++] = cur.val;
        }
        return result;
    }
