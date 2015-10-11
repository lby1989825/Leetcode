package StringtoInteger_atoi;

/**
 * 
 * @author boyangli
 * ��ȷ��integer�ļ���ֵ
 * �ҵ���һ�����ǿո�ģ������ǡ��������ǡ�����
 * ���޻���num == maxDiv10 && digit >= 8
 * Ҫע�⣺
 * i �Ǵ�ͷ�ҵ�β��ֻ�ñ���һ�飬�ҵ���һ�������� ���� ��Ҫֹͣ
 * ����ֵ�Ĵ���һ��ҪС��
 * if(num > MAXDIV10 || num == MAXDIV10 && digit >= 8){
    			if(sign == 1){
    				return Integer.MAX_VALUE;
    			}
    			else{
    				return Integer.MIN_VALUE;
    			}
    		}
 */
public class Solution {
	public static final int MAXDIV10 = Integer.MAX_VALUE / 10;
    public int atoi(String str) {
    	int i = 0, sign = 1;
    	while(i < str.length()){
    		if(str.charAt(i) == ' '){
    			i++;
    		}
    		else if(str.charAt(i) == '+'){
    			i++;
    			break;
    		}
    		else if(str.charAt(i) == '-'){
    			sign = -1;
    			i++;
    			break;
    		}
    		else{
    			break;
    		}
    	}
    	int num = 0;
    	while(i < str.length() && Character.isDigit(str.charAt(i))){
    		int digit = Character.getNumericValue(str.charAt(i));
    		if(num > MAXDIV10 || num == MAXDIV10 && digit >= 8){
    			if(sign == 1){
    				return Integer.MAX_VALUE;
    			}
    			else{
    				return Integer.MIN_VALUE;
    			}
    		}
    		else{
    			num = num * 10 + digit;
    			i++;
    		}
    	}
    	return sign * num;
    }
}
