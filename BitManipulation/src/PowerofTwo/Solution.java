package PowerofTwo;

public class Solution {
    public boolean isPowerOfTwo(int n) {
    	if(n == Integer.MIN_VALUE) return false;
		int count = 0;
        for(int i=0; i < 32; i++) {
            if((n & 1<<i) != 0) count++;
        }
        return count == 1;
    }
}
