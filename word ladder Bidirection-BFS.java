    public class Solution {
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start.equals(end)) {
                return 2;
            }

            int length1 = 1;
            int length2 = 1;
            HashSet<String> used1 = new HashSet<String>();
            HashSet<String> used2 = new HashSet<String>();
            used1.add(start);
            used2.add(end);
            Queue<String> q1 = new LinkedList<String>();
            Queue<String> q2 = new LinkedList<String>();
            q1.offer(start);
            q2.offer(end);

            while (!q1.isEmpty() && !q2.isEmpty()) {
                int size1 = q1.size();
                while (size1-- > 0) {
                    String curr = q1.poll();
                    ArrayList<String> trans = transform(curr);
                    for (String s : trans) {
                        if (used2.contains(s)) {
                            return length1 + length2;
                        }
                        if (dict.contains(s) && !used1.contains(s)) {
                            q1.offer(s);
                            used1.add(s);
                        }
                    }
                }
                length1++;

                int size2 = q2.size();
                while (size2-- > 0) {
                    String curr = q2.poll();
                    ArrayList<String> trans = transform(curr);
                    for (String s : trans) {
                        if (used1.contains(s)) {
                            return length1 + length2;
                        }
                        if (dict.contains(s) && !used2.contains(s)) {
                            q2.offer(s);
                            used2.add(s);
                        }
                    }
                }
                length2++;
            }

            return 0;
        }

        private ArrayList<String> transform(String str) {
            ArrayList<String> trans = new ArrayList<String>();
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != str.charAt(i)) {
                        arr[i] = c;
                        trans.add(new String(arr));
                    }
                }
                arr[i] = str.charAt(i);
            }
            return trans;
        }
    }
