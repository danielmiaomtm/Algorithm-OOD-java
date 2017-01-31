public int[] mergeTwoArray (int[] num1, int[] num2) {
    int i1 = 0, i2 = 0;
    int[] nums = new int[num1.length + num2.length - 1];
    while (i1 < num1.length && i2 < num2.length) {

        if (num1[i1] < num2[i2]) {
            nums[i1 + i2] = num1[i1++];
        } else {
            nums[i1 + i2] = num2[i2++];
        }

    }
    // i1或者i2多加了一次
    while (i1 < num1.length) {
        nums[i1 + i2 - 1] = num1[i1++];
    }
    while (i2 < num2.length) {
        nums[i1 + i2 - 1] = num2[i2++];
    }
    return nums;
}



//Time O(nlgn)
//Space: O(rowNum);


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
