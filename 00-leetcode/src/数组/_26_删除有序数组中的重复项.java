package 数组;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class _26_删除有序数组中的重复项 {

	public int removeDuplicates(int[] nums) {
		if(nums.length == 0)return 0;
		int fast = 1;
		int slow = 1;
		while(fast < nums.length) {
			if(nums[fast] != nums[slow -1]) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		_26_删除有序数组中的重复项 test = new _26_删除有序数组中的重复项();
		System.out.println(test.removeDuplicates(nums));
	}

}
