package InsertionSortList;
/**
 * 
 * @author lby
 * ����ָ��cur �� temp���Ϊhead.next �� head
 * ���temp < cur, temp�����ƣ��غ�����cur�����ƣ�temp�ƻ�head
 * ���temp��> cur �� ���غϣ��Ƚ���ֵ��Ȼ��temp�����ƣ�ֱ���غ�
 */

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode cur = head.next;
		while(cur != null) {
			ListNode temp = head;
			while(temp.val < cur.val && temp != cur) temp = temp.next;
			while(temp != cur) {
				int tempVal = temp.val;
				temp.val = cur.val;
				cur.val = tempVal;
				temp = temp.next;
			}
			cur = cur.next;
		}
		return head;
    }
}
