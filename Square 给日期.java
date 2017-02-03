/*给几几年几月几号礼拜几， 算出现在是礼拜几
*/

	  String[] map = new String[]{"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

	  public String printDate(String ref, String date1) {
		// get the date  
	    String[] refs = ref.split("-");
	    
	    int refYear = Integer.parseInt(refs[0]);
	    int refMonth = Integer.parseInt(refs[1]);
	    int refDay = Integer.parseInt(refs[2]);
	    int refDate = -1;

	    for (int i = 0; i < map.length; i++) {
	      if (map[i].equals(refs[3])) {
	        refDate = i;
	      }
	    }

	    String[] cur = date1.split("-");
	    
	    int curYear = Integer.parseInt(cur[0]);
	    int curMonth = Integer.parseInt(cur[1]);
	    int curDay = Integer.parseInt(cur[2]);
	     
	    
	    // get the totalDays
	    int totalDays = 0;
	    
    	for (int i = (int)Math.min(curYear, refYear); i < (int)Math.max(curYear, refYear); i++) {
    		totalDays += isLeapYear(i) ? 366 : 365;
    	}
    	
    	if (curYear < refYear) {
    		totalDays = totalDays - countDays(curYear, curMonth, curDay) + countDays(refYear, refMonth, refDay);
    		return map[(refDate - totalDays % 7 + 7) % 7];
    		
    	} else {
    		totalDays = totalDays - countDays(refYear, refMonth, refDay) + countDays(curYear, curMonth, curDay);
    		return map[(refDate + totalDays % 7) % 7];
    	}
	    		       
	  }
	  
	  
	  public boolean isLeapYear (int year) {
		  return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
	  }
		  
	  public int countDays (int year, int month, int day) {
		  int totalDays = 0;
		  //add to the last month
		  for (int i = 1; i < month; i++) {
			  if (i <= 7) {
				  if (i == 2) {
					  totalDays += isLeapYear(year) ? 29 : 28;
				  } else if (i % 2 == 0) {
					  totalDays += 30;
				  } else {
					  totalDays += 31;
				  }
			  } else {
				  if (i % 2 == 0) {
					  totalDays += 31;
				  } else {
					  totalDays += 30;
				  }
			  }
		  }
		  totalDays += day;
		  return totalDays;		
		  
	  }
	  
    
    
    
    
    
    
    
    
    
    
    
    
    
  //简单版本  
  String[] map = new String[]{"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	
	public String printDate (String refStr, String curStr) {
		String[] refs = refStr.split("-");
	    
	    int refYear = Integer.parseInt(refs[0]);
	    int refMonth = Integer.parseInt(refs[1]);
	    int refDay = Integer.parseInt(refs[2]);
	    int refDate = -1;

	    for (int i = 0; i < map.length; i++) {
	      if (map[i].equals(refs[3])) {
	        refDate = i;
	      }
	    }

	    String[] cur = curStr.split("-");
	    
	    int curYear = Integer.parseInt(cur[0]);
	    int curMonth = Integer.parseInt(cur[1]);
	    int curDay = Integer.parseInt(cur[2]);
		
		
		Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        
        // Set the date for both of the calendar instance
        cal1.set(refYear, refMonth, refDay);
        cal2.set(curYear, curMonth, curDay);

        // Get the represented date in milliseconds
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();
        
        // Calculate difference in milliseconds
        long diff = Math.abs(milis1 - milis2);
        
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        System.out.println(diffDays );
        if (diff < 0) {
        	// ref  cur
        	return map[(int)(refDate +  diffDays % 7) % 7];
        } else if (diff > 0){
        	// cur  ref
        	return map[(int)(refDate - diffDays  % 7 + 7) % 7];
        } else {
        	return map[refDate];
        }
        
        
	}
    
    
    
