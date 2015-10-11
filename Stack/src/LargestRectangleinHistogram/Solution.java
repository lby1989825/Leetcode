package LargestRectangleinHistogram;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {
    	int i = 0, maxArea = 0;
    	int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        Stack<Integer> stack = new Stack<Integer>();
    	while(i < h.length) {
    		if(stack.isEmpty() || h[stack.peek()] <= h[i]) stack.push(i++);
    		else {
    			int top = stack.pop();
    			//��һ�����н�������Ϊstack�յ���λ�ǵ�iΪֹĿǰ���
    			if(stack.isEmpty()) {
    				maxArea = Math.max(maxArea, h[top] * i);
    			}
    			else {
    				maxArea = Math.max(maxArea, h[top] *(i - stack.peek() - 1));
    			}
    		}
    	}
    	return maxArea;
    }
}