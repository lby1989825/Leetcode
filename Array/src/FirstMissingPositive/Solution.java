package FirstMissingPositive;

public class Solution {
	public int firstMissingPositive(int[] A) {
		boolean[] B = new boolean[100000];
		for(int i = 0; i < A.length; i++) {
			if(A[i] > 0) B[A[i]] = true;
		}
		int j = 1;
		while(j < B.length) {
			if(B[j] == false) break;
			j++;
		}
		return j;
	}
}
