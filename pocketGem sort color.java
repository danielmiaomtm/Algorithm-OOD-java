/*
有很多PG object, object 有 color（String） property.

给个array, 里面存有很多PG object,有多种颜色，比如红，绿，蓝， 黄，紫。
要求排序， 红， 绿，蓝在前面， 别的颜色在后面。比如 [红，红，绿， 绿，绿，蓝，蓝， 黄，紫]。 黄，紫不要求排序， 只排序红，绿，蓝。

*/

public void sort (String[] input) {

//first get the right boundary
    int left = 0;
    int right = input.length - 1;
    int index = 0;
    while (index <= right) {
      if (!input[index].equals("red") && !input[index].equals("green") && !input[index].equals("blue")) {
        swap(input, index, right--);
      } else {
        index++;
      }
    }
    
//sort 3 colors
    index = left;
    while (index <= right) {
      if (input[index].equals("red")) {
        swap(input, index++, left++);
      } else if (input[index].equals("blue")) {
        swap(input, index, right--);
      } else if (input[index].equals("green")) {
        index++;
      }
    } 
    
    
  }
  public void swap (String[] input, int n1, int n2) {
    String temp = input[n1];
    input[n1] = input[n2];
    input[n2] = temp;
  }
  
