package SimplifyPath;

import java.util.Stack;

/**
 * 
 * @author boyangli
 * path = "/home/" => "/home"
   path = "/a/./b/../../c/" => "/c"
   input    "/../..home/./.games/nba2k14/nba/../lnu/."
   output   /..home/.games/nba2k14/lnu

 */
public class Solution {
	public String simplifyPath(String path) {
	    if(path == null || path.length()==0) {
	        return "";
	    }
	    Stack<String> stack = new Stack<String>();
	    StringBuilder res = new StringBuilder();
	    int i = 0;	    
	    while(i < path.length()) {
	        int index = i;
	        StringBuilder temp = new StringBuilder();
	        while(i < path.length() && path.charAt(i) != '/') {
	            temp.append(path.charAt(i));
	            i++;
	        }
	        if(index != i) {
	            String str = temp.toString();
	            if(str.equals("..")) {
	                if(!stack.isEmpty()) stack.pop();
	            }
	            else if(!str.equals(".")) stack.push(str);
	        }
	        i++;
	    }
	    if(!stack.isEmpty()) {
	        String[] strs = stack.toArray(new String[stack.size()]);
	        for(int j = 0; j < strs.length; j++) res.append("/" + strs[j]);
	    }
	    if(res.length() == 0) return "/";
	    return res.toString();
	}
}