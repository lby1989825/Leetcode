package UniqueBinarySearchTrees;
/**
 * 
 * @author lby
 * ����int n��˵����n��ֵ������Ϊroot
 * assuming i is the value that we choose to be the root
 * The value in left subtree are from 1 to i �C 1, 
 * and the values in right subtree are from i + 1 to n
 * If 1 to i �C 1 can form p different trees, 
 * and i + 1 to n can form q different trees, then we will have p * q trees when i is the root.
 *
 */

public class Solution {
	public int numTrees(int n) {
		int[] N = new int[n + 1];
		N[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < i; j++){
				N[i] += N[j] * N[i - j - 1];
			}
		}
		return N[n];
    }
}
