package WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	Set<String> unvisitedSet = new HashSet<String>();
    	unvisitedSet.addAll(dict);
    	unvisitedSet.add(start);
    	unvisitedSet.remove(end);
    	Map<String, List<String>> nextMap = new HashMap<String, List<String>>();
    	for (String e : unvisitedSet) {
    		nextMap.put(e, new ArrayList<String>());
    	}
    	Queue<StringWithLevel> queue = new LinkedList<StringWithLevel>();
        queue.add(new StringWithLevel(end, 0));
    	boolean found = false;
    	int finalLevel = Integer.MAX_VALUE, curLevel = 0, preLevel = 0;
    	Set<String> visitedCurLevel = new HashSet<String>();
    	while (!queue.isEmpty()) {
    		StringWithLevel cur = queue.poll();
    	    String curStr = cur.str;
    	    curLevel = cur.level;
    	    if(found && curLevel > finalLevel) break;
    	    if (curLevel > preLevel) unvisitedSet.removeAll(visitedCurLevel);
    	    preLevel = curLevel;
    	    char[] curStrCharArray = curStr.toCharArray();
    	    for (int i = 0; i < curStr.length(); ++i) {
    	    char originalChar = curStrCharArray[i];
    	    boolean foundCurCycle = false;
    	    for (char c = 'a'; c <= 'z'; ++c) {
    	    	curStrCharArray[i] = c;
    	        String newStr = new String(curStrCharArray);
    	        if(c != originalChar && unvisitedSet.contains(newStr)) {
    	        	nextMap.get(newStr).add(curStr);
    	        	if(newStr.equals(start)) {
    	        		found = true;
    	                finalLevel = curLevel;
    	                foundCurCycle = true;
    	                break;
    	                }
    	        	if(visitedCurLevel.add(newStr)) {
    	        		queue.add(new StringWithLevel(newStr, curLevel + 1));
    	        		}
    	            }
    	         }
    	         if(foundCurCycle) break;
    	         curStrCharArray[i] = originalChar;
    	     }
    	   }
    	   if(found) {
    	       List<String> list = new ArrayList<String>();
    	       list.add(start);
    	       getPaths(start, end, list, finalLevel + 1, nextMap, res);
    	   }
    	   return res;
    }

	private void getPaths(String cur, String end, List<String> list, int level, Map<String, List<String>> nextMap, List<List<String>> res) {
    	   if(cur.equals(end)){
    	      res.add(new ArrayList<String>(list));
    	   }
    	   else if(level > 0){
    		   List<String> parentsSet = nextMap.get(cur);
    	       for(String parent : parentsSet) {
    	    	   list.add(parent);
    	           getPaths(parent, end, list, level - 1, nextMap, res);
    	           list.remove(list.size() - 1);
    	       }
    	   }
    }
}

