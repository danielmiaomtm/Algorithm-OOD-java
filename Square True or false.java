	/*
  input string（“true & false | true”） return boolean true

  */
  
  public String trueOrFalse(String input) {
		String pre = null;
		String cur = null;
		String operator = "";

		int start = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == '&' || c == '|') {
      
				if (pre == null) {
					pre = input.substring(start, i).trim();
					operator = c + "";
				} else {
					cur = input.substring(start, i).trim();
				}
        //update start pointer
				start = i + 1;
				
				//update start, skip white space;
				while (start < input.length()) {
					if (Character.isLetter(input.charAt(start))) {
						break;
					}
					start++;
				}
				
				if (operator.length() != 0 && pre != null && cur != null) {
					pre = operation(pre.trim(), cur.trim(), operator);
				}
				//update op
				operator = c + "";				
				
			}
				
		}
		// there is one left 
		cur = input.substring(start, input.length()).trim();

		if (operator.length() != 0 && pre != null && cur != null) {
			pre = operation(pre, cur, operator);
		}

		
		return pre == null ? cur : pre;
	}
	
	public String operation (String str1, String str2, String operator) {
		Boolean result;
		if (operator.equals("&")) {
			result = Boolean.parseBoolean(str1) & Boolean.parseBoolean(str2);
		} else {
			result = Boolean.parseBoolean(str1) | Boolean.parseBoolean(str2);
		}
		return String.valueOf(result);
	}
