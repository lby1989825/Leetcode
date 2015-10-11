package TextJustification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<String>();
    	if(words.length == 0) return res;
    	int start = 0, end = 0,tempLen = 0, wordLen = 0;
    	while(end < words.length) {
    		boolean happen = false;
        	while(end < words.length && tempLen <= maxWidth) {
        		wordLen += words[end].length();
        		tempLen += words[end].length();
        		if(tempLen == maxWidth) {//���һ������������һ�е�case
        			end++;
        			tempLen++;
        			happen = true;
        		}
        		else if(tempLen < maxWidth) {
        			end++;
        			tempLen++;
        		}
        	}
    		if(end != words.length && !happen) helper(Arrays.copyOfRange(words, start, end), wordLen - words[end].length(), maxWidth, res, end, words.length);
    		else if(end != words.length && happen) helper(Arrays.copyOfRange(words, start, end), wordLen, maxWidth, res, end, words.length);
    		else helper(Arrays.copyOfRange(words, start, end), wordLen, maxWidth, res, end, words.length);//���һ��
    		start = end;
    		tempLen = 0;
    		wordLen = 0;
    		happen = false;
    	}
		return res;
    }

	private void helper(String[] str, int wordLen, int maxWidth, List<String> res, int end, int len) {
		// TODO Auto-generated method stub
		int spaceLen = maxWidth - wordLen, spaceCount = str.length - 1;
		String[] space = createSpaceString(spaceLen, Math.max(spaceCount, 1)); //����Ҫ��Ŀո�һ������
		String s = "";
		if(end == len) { //���һ�е�����case
			int i = 0;
			while(i < str.length) {
				s += str[i] + " ";
				i++;
			}
			while(i < maxWidth) {
				s += " ";
				i++;
			}
			res.add(s.substring(0, maxWidth));
		}
		else {
			if(str.length == 1) s += str[0] + space[0]; //����ֻ��һ���ʵ�����case
		    else { //����case
		    	for(int i = 0; i < space.length; i++) {
					s += str[i] + space[i];
				}
		    	s += str[str.length - 1];
		    }
			res.add(s);
		}
	}

	private String[] createSpaceString(int spaceLen, int spaceCount) { //�����ո�����
		// TODO Auto-generated method stub
		String[] s = new String[spaceCount];
		for(int i = s.length - 1; i > -1; i--) {
			s[i] = toSpaceString(spaceLen / spaceCount);
			spaceCount--;
			spaceLen -= s[i].length();
		}
		return s;
	}

	private String toSpaceString(int count) { 
		// TODO Auto-generated method stub
		String s = "";
		for(int i = 0; i < count; i++) {
			s += " ";
		}
		return s;
	}
}
