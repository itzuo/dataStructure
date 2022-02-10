package 数组;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 */
public class _27_移除元素 {

	 public int removeElement(int[] nums, int val) {
		 int fast = nums.length -1;
		 int slow = 0;
		 while (slow <= fast) {
			if(nums[slow] == val) {
				if(nums[fast] != val) {
					nums[slow] = nums[fast];
					slow++;
					fast--;
				}else {
					fast--;
				}
			}else {
				slow++;
			}
		}
		 return slow;
	 }
	 
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		_27_移除元素 test = new _27_移除元素();
		test.removeElement(nums, 3);
	}

}
