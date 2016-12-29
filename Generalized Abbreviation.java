Example:
Given "word"
Return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]



// totally should be 2^n, so it has binary representation numbers

public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, word.length()); i++) {

            int temp = i;
            int count = word.length() - 1;
            StringBuilder sb = new StringBuilder();
            int num = 0;

            while (count >= 0) {
                if ((temp & 1) == 0) {
                    if (num > 0) {
                        sb.insert(0, num);
                        num = 0;
                    }
                    sb.insert(0, word.charAt(count));
                } else {
                    if (num == 0) {
                        num = 1;
                    } else {
                        num++;
                    }
                }
                temp >>= 1;
                count--;
            }

            if (num > 0) {
                sb.insert(0, num);
            }

            result.add(sb.toString());

        }
        return result;
}
