class Node {
        int val;
        int x;
        int y;
        Node(x, y, val) {}
        this.val = val;
        this.x = x;
        this.y = y;
    }
    public int[] merge(int[][] arrayOfArrays) {
        
        
        PriorityQueue<Node> heap = new PriorityQueue<>(11, new Comparator<Node>({
            public int compare (Node n1, Node n2) {
                return n1.val - n2.val;
            }
        }));
        int len = 0;
        for (int i = 0; i < arrayOfArrays; i++) {
            len += array.length;
            if (array != null && array.length > 0) {
                Node cur = new Node(i, 0, arrayOfArrays[i][0]);     
                heap.offer(cur);
            }
        }
        
        int[] result = new int[len];
        int pos = 0;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            if (cur.y + 1 < arrayOfArrays[cur.x].length) {
                heap.offer(new Node(cur.x, cur.y + 1, arrayOfArrays[cur.x][cur.y + 1]);
            }
            result[pos++] = cur.val;
        }
                           
        return result;
    }
