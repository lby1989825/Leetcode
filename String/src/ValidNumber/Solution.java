package ValidNumber;

public class Solution {
    public boolean isNumber(String s) {
    	int i = 0, n = s.length();
    	//ǰ��Ŀո����
    	while(i < n && s.charAt(i) == ' ') i++;
    	//�ҵ���һ�������ߣ�
    	if(s.charAt(i) == '+' || s.charAt(i) == '-') i++;
    	boolean isNumber = false;   	
    	//�Ӽ��ź��棬����û�����Ӽ��ţ���������ĸ
    	while(i < n && Character.isDigit(s.charAt(i))) {
    		i++;
    		isNumber = true;
    	}
    	//�������.
    	if(i < n && s.charAt(i) == '.') {
    		i++;
    		while(i < n && Character.isDigit(s.charAt(i))){
    			i++;
    			isNumber = true;
    		}
    	}
    	//�������e
    	if(isNumber && i < n && s.charAt(i) == 'e'){
    		i++;
    		isNumber = false;
    	    //���e�������������˴�Ϊe�ļ���
    	    if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
    	    	i++;
    	    }
    	    //���������Ϊ��ĸ�����û�����������˴�Ҳ����Ϊ��ĸ
    	    while(i < n && Character.isDigit(s.charAt(i))) {
    	    	i++;
    	    	isNumber = true;
    	    }
    	}    
    	//���İ׿ո���
    	while(i < n && Character.isWhitespace(s.charAt(i))){
    		i++;
    	}
    	return i == n && isNumber;
    }
}