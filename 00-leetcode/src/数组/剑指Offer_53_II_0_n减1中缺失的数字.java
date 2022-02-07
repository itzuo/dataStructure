package 数组;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class 剑指Offer_53_II_0_n减1中缺失的数字 {

	 public int missingNumber(int[] nums) {
		 int left = 0,right = nums.length -1;
		 while(left <= right) {
			 int mid = (left + right) >> 1;
		 	if(nums[mid] == mid) {// 不可能存在小于的情况
		 		left = mid + 1;
		 	}else {
				right = mid -1;
			}
		 }
		 return left;
	 }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6,7,9};
		剑指Offer_53_II_0_n减1中缺失的数字 test = new 剑指Offer_53_II_0_n减1中缺失的数字();
		System.out.println(test.missingNumber(nums));
	}
}
