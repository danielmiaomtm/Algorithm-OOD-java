/*
給你一個keyboard layout qwertyuio asdfghjkl zxcvbnm 再給你一個點double x, double y return 對應的letter ex: q的範圍是x:0-1, y:0-1, 
w的範圍是x:0-1, y:1-2 follow up 如果keyboard是支援swipe, input為第一個按下去的點x, y,
再加上diff array, array內的element是多的點，每個element存了與上一點的坐標的diff x, diff y, 求出整個string 

链接: https://instant.1point3acres.com/thread/137951
来源: 一亩三分地
*/	
  
  char[][] keyBoard = new char[][]{{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o'},
							         {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
							         {'z', 'x', 'c', 'v', 'b', 'n', 'w'}};
        
	public String getWord (double x, double y) {
	    Character result = null;
	    if (x < 0 || x > 3 || y < 0 || y > 9 || (2 < x && x <= 3 && y > 7)) {
	    	return "";
	    }
	    return keyBoard[(int)x][(int)y] + "";
	  }
	  
	  public String swipe (double x, double y, List<Element> diffArray) {
		  
		  StringBuilder sb = new StringBuilder();  
		  
		  sb.append(getWord(x, y));
      
		  for (Element e : diffArray) {
			  double curX = x + e.diffX;
			  double curY = y + e.diffY;
			  sb.append(getWord(curX, curY));
			  x = curX;
			  y = curY;
		  }
		  return sb.toString();
	  }
	  
