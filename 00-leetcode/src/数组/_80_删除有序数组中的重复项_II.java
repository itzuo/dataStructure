package 数组;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 */
public class _80_删除有序数组中的重复项_II {

	/**
	 * 因为给定数组是有序的，所以相同元素必然连续。我们可以使用双指针解决本题，
	 * 遍历数组检查每一个元素是否应该被保留，如果应该被保留，就将其移动到指定位置。
	 * 具体地，我们定义两个指针slow和fast分别为慢指针和快指针，其中慢指针表示处理出的数组的长度，
	 * 快指针表示已经检查过的数组的长度，即nums[fast] 表示待检查的第一个元素，
	 * nums[slow−1] 为上一个应该被保留的元素所移动到的指定位置。
	 * 
	 * 因为本题要求相同元素最多出现两次而非一次，所以我们需要检查上上个应该被保留的元素nums[slow−2] 
	 * 是否和当前待检查元素nums[fast] 相同。当且仅当nums[slow−2]=nums[fast]时，
	 * 当前待检查元素nums[fast]不应该被保留（因为此时必然有nums[slow−2]=nums[slow−1]=nums[fast]）。
	 * 最后，\textit{slow}slow 即为处理好的数组的长度。
	 * 
	 * 特别地，数组的前两个数必然可以被保留，因此对于长度不超过 22 的数组，我们无需进行任何处理，
	 * 对于长度超过 22 的数组，我们直接将双指针的初始值设为 22 即可。
	 */
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if(n <=2) return n;
		int fast = 2;
		int slow = 2;
		while (fast < n) {
			if(nums[fast] != nums[slow - 2] ) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		
		for(int i=0;i<slow;i++) {
			System.out.print(nums[i] + " ");
		}
		return slow;
    }
	
	// 通用保留k个重复项
	public int removeDuplicates02(int[] nums) {
		return process(nums,3);
	}
	
	public int process(int[] nums, int k) {
		int n = nums.length;
		if(n <= k) return n;
		int fast = k;
		int slow = k;
		while (fast < n) {
			if(nums[fast] != nums[slow - k] ) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		
		for(int i=0;i<slow;i++) {
			System.out.print(nums[i] + " ");
		}
		return slow;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,2,2,2,2,2,2,3,4,4,4,4,4};
		_80_删除有序数组中的重复项_II test = new _80_删除有序数组中的重复项_II();
		test.removeDuplicates02(nums);
	}

}
