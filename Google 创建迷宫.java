/*
如何创建迷宫，需要保证只有一条路径到出口并且所有tile都能reach.

迷宫墙总数是(2*n*(n-1) - (n*n - 1))
   

input : 
List<List<String>> res = sol.findAllPath(3, "00", "20");
for (List<String> list : res) {
  System.out.println(Arrays.toString(list.toArray()));
}
   
output:
[00, 01, 02, 12, 22, 21, 11, 10, 20]
[00, 10, 11, 01, 02, 12, 22, 21, 20]

*/

int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
Map<String, Boolean> visited = new HashMap<>();
int n;
public List<List<String>> findAllPath (int n, String start, String end) {
  List<List<String>> result = new ArrayList<>();
  this.n = n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {				
      visited.put(String.valueOf(i) + String.valueOf(j), false);
    }
  }	

  List<String> path = new ArrayList<>();		
  helper (start, end, path, result);
  return result;
}
public void helper (String start, String end, List<String> path, List<List<String>> result) {
  if (start.equals(end)) {
    path.add(end);
    if (path.size() == n * n) {
      result.add(new ArrayList<>(path));
    }
    path.remove(path.size() - 1);
    return;
  }
  if ((start.charAt(0) - '0' < 0) || (start.charAt(0) - '0' >= n) 
   || (start.charAt(1) - '0' < 0) || (start.charAt(1) - '0' >= n)) {
    return;
  }

  if (visited.get(start)) {
    return;
  }

  visited.put(start, true);
  path.add(start);

  for (int[] d : dir) {
    int x = d[0] + (start.charAt(0) - '0');
    int y = d[1] + (start.charAt(1) - '0');
    helper(String.valueOf(x) + String.valueOf(y), end, path, result);
  }

  visited.put(start, false);
  path.remove(path.size() - 1);

}
