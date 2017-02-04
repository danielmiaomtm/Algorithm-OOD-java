public String simplifyPath(String path) {
        
      StringBuilder sb = new StringBuilder();
      Stack<String> stack = new Stack<>();
      int i = 0;
      while (i < path.length()) {
          if (path.charAt(i) == '/') {
              int j = i + 1;
              while (j < path.length() && path.charAt(j) != '/') {
                  j++;
              }
              String p = path.substring(i + 1, j);
              if (p.equals("..")) {
                  if (!stack.isEmpty()) {
                      stack.pop();
                  }
              } else {
                  if (!p.equals(".") && !p.equals("")) {
                      stack.push(p);
                  }
              }
              i = j;
          }
      }


      for (String s : stack) {
          sb.append("/" + s);
      }

      return sb.length() == 0 ? "/" : sb.toString();
}
