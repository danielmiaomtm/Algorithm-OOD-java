/*
you have an img data as an array, output the data for upsampling. For 
example, 
[1, 2, 3, 4, 5, 6] as width 3(2 rows) ==> upsample 2 times would be [1 1 2 2
3 3 1 1 2 2 3 3 4 4 5 5 6 6 4 4 5 5 6 6]
*/


public int[] upsampling(int[] arr, int width, int times):
  int new_width = width * times;
  int new_height = arr.length / width * times;
  int[] ans = new int[new_width * new_height];

  for (int i = 0; i < ans.length; i++) {
      int row, col = i / new_width / times, i % new_width / times;
      int ori_index = row * width + col;
      ans[i] = arr[ori_index]
  }
  
  return ans;
}
