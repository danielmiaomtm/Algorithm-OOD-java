/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] chars = new char[4];
    int charsPoint = 0;
    int charsCount = 0;
    
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (charsPoint == 0) {
                charsCount = read4(chars);
            }
            while (total < n && charsPoint < charsCount) {
                buf[total++] = chars[charsPoint++];
            }
            //all chars in chars has been used up, set pointer to 0
            if (charsPoint == charsCount) {
                charsPoint = 0;
            }
            //read4 returns less than 4, end of file
            if (charsCount < 4) {
                break;
            }
        }
        return total;
    }
}

/*
Note:
The read function will only be called once for each test case.
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean end = false;
        int total = 0;
        char[] temp = new char[4];
        
        while (!end && total < n) {
            int count = read4(temp);
            end = count < 4;
            
            count = Math.min(count, n - total);
            
            for (int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }
        
        return total;
    }
}
