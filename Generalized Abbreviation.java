Example:
Given "word"
Return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]



// totally should be 2^n, so it has binary representation numbers

public List<String> generateAbbreviations(String word) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, word.length()); i++) {
            String out = "";
            int count = 0;
            int t = i;
            for (int j = 0; j < word.length(); j++) {
                if ((t & 1) == 1) {
                    count++;
                    if (j == word.length() - 1) {
                        out += Integer.toString(count);
                    }
                } else {
                    if (count != 0) {
                        out += Integer.toString(count);
                        count = 0;
                    }
                    out += word.charAt(j);;
                }
                t >>= 1;
            }
            result.add(out);
        }
        return result;
    }
