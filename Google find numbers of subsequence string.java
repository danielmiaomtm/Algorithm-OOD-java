/*
Question: Given two strings, find number of discontinuous matches.
Example: “cat”, “catapult”
Output: 3   => “CATapult”, “CatApulT”, “CAtapulT”
*/


public int match (String target, String source){
		int [][] f = new int[target.length() + 1][source.length() + 1] ;
		for (int i = 0 ; i <= source.length() ; ++i) {
			f[0][i] = 1;
		}
		f[0][0] = 1;
		for (int i = 1 ; i <= target.length() ; ++i) {
		 for (int j = 1 ; j <= source.length() ; ++j) {
			 if (target.charAt(i - 1) == source.charAt(j - 1)) {
				 f[i][j] = f[i - 1][j - 1] + f[i][j - 1] ;  
			 } else{
				 f[i][j] = f[i][j - 1] ;
			 }
		 }
		}
		return f[target.length()][source.length()] ;
}


//recursion

public static int discontinousMatch(String s1, String s2)
	{
		int total = 0;
		if(s1.length() == 1)
		{
			int count =0;
			while(s2.contains(s1))
			{
				count++;
				s2 = s2.substring(s2.indexOf(s1.charAt(0))+1);
				
			}
			return count;
		}
		
		char c = s1.charAt(0);
		
		int index = s2.indexOf(c);
		while (index < s2.length() && index > -1)
		{
			
			total += discontinousMatch(s1.substring(1), s2.substring(index+1));
			index = s2.indexOf(c, index+1);
		}
		
		return total;
	}
