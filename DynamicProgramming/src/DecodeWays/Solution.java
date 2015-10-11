package DecodeWays;

public class Solution {
    public int numDecodings(String s) {
    	if(s.length() == 0 || s.charAt(0) == '0') return 0;
    	int[] dp = new int[s.length() + 1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for(int i = 2; i < dp.length; i++) {
    		int temp1 = Integer.parseInt(s.substring(i - 1, i));
    		if(temp1 != 0) dp[i] = dp[i - 1];
    		int temp2 = Integer.parseInt(s.substring(i - 2, i));
    		if(temp2 > 0 && temp2 < 27 && s.charAt(i - 2) != '0') dp[i] += dp[i - 2];
    	}
    	return dp[s.length()];
    }
}
