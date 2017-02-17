	/*
  给一堆button 1 2 3 4 5 ， 可以按很多次，但是不能有重复，每次按的button可以是多个button的组合，like 1-23-4，

        1-23-4 跟 1-32-4不算重复，1-23-34算重复，
        输出所有可能的按法。
  
  [1, 12, 123, 12-3, 13, 132, 13-2, 1-2, 1-23, 1-2-3, 1-3, 1-32, 1-3-2, 
   2, 21, 213, 21-3, 23, 231, 23-1, 2-1, 2-13, 2-1-3, 2-3, 2-31, 2-3-1, 
   3, 31, 312, 31-2, 32, 321, 32-1, 3-1, 3-12, 3-1-2, 3-2, 3-21, 3-2-1]

  
  */	
  
  
  
 public  List<String>  buttonCombine(List<Integer> nums){
         List<String> re = new ArrayList<String>();
         boolean[] used = new boolean[nums.size()];
         help(re,0, new StringBuilder(), used, nums);
         return re;
    }
    
    public static void help( List<String> r,int level, StringBuilder sb, boolean[] used, List<Integer> nums){
        
        if(sb.length()!=0 && sb.charAt(sb.length() - 1) != '-'){
        	StringBuilder newsb = new StringBuilder(sb);
            r.add(newsb.toString());
        }
        
        if(level >= nums.size()) return;
        
        for(int i = 0; i < nums.size(); i++){
        	if(!used[i]){
        		used[i] = true;
                sb.append(nums.get(i));
                help(r,level + 1, sb, used, nums);
                sb.deleteCharAt(sb.length() - 1);
                if(level != nums.size() - 1){
                	sb.append(nums.get(i) + "-");
                	help(r,level + 1, sb, used, nums);
                	sb.delete(sb.length() - 2, sb.length());
                }
                used[i] = false;
            }
       }
    }
