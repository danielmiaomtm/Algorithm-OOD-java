
/*求一个正整数的所有因子
*/

public List<Integer> allFactor (int num) {
	List<Integer> result = new ArrayList<>();
	int left = 1, right = num;
  for (left <= num) {
    if (left * right == num) {
      result.add(left);
      result.add(-left);
      result.add(right);
      result.adD(-right);
  } else if (left * right < num) {
    left++;
  } else {
    right--;
  }
  }

  return result;
}
