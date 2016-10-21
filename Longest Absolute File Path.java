/*
The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty 
second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, 
in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including 
the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the 
abstracted file system. If there is no file in the system, return 0.
*/



public class Solution {
    public int lengthLongestPath(String input) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int max = 0;
        int result = 0;
        for (String str : input.split("\n")) {
          // get the level of directory 
            int index = str.lastIndexOf("\t") + 1;
            // get the wordLen
            int strLen = str.substring(index).length();
            // if str contains dot, it means to the end of file path, update result
            if (str.contains(".")) {
                result = Math.max(map.get(index) + strLen, result);
            } else {
            // put/update the cur strLen in map
               map.put(index + 1, map.get(index) + strLen + 1);
            }
        }
        
        return result;
        
    }
}
