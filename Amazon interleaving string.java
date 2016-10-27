/*
str1 : ab
str2 : cd
output（保持相对顺序） : 
abcd
acbd
acdb
cabd
cadb
cdab
*/
void helper2(vector<string> & input, vector<int> index, string path, int & maxLength, vector<string> & result) {
    for (int i = 0; i < index.size(); i++) {
        if (index[i] > input[i].size())
            return;
    }   

    if (maxLength == path.size()) {
        result.push_back(path);
        return;
    }
    
    for (int i = 0; i <index.size(); i++) {
        index[i]++;
        helper2(input, index, path + input[i][index[i]-1], maxLength, result);
        index[i]--;
    }
}

void helper(string str1, int row, string str2, int col, string path, vector<string> & result) {
    if (row > 2 || col > 2) {
        return;
    }
    if (row == 2 && col == 2) {
        result.push_back(path);
        return;
    }
    
        helper(str1, row + 1, str2, col, path + str1[row], result);    
        helper(str1, row, str2, col + 1, path + str2[col], result);

}
