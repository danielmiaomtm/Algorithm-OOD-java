	public List<List<Integer>> subsets (List<Integer> input) {
		List<List<Integer>> result = new ArrayList<>();
		if (input == null || input.size() == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<>();
		Collections.sort(input);
		helper(input, result, list, 0);
		return result;
	}
	public void helper (List<Integer> input, List<List<Integer>> result, List<Integer> list, int index) {
		result.add(new ArrayList<>(list));

		for (int i = index; i < input.size(); i++) {
			// if there is duplicates one, skip
			// i != index, means if it is the first time visited add into list, otherwise it should skip
			if (i != index && input.get(i) == input.get(i - 1)) {
				continue;
			}
			list.add(input.get(i));
			helper (input, result, list, i + 1);
			list.remove(list.size() - 1);
		}

	}
