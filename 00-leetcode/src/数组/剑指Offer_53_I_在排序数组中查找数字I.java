package 数组;
/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class 剑指Offer_53_I_在排序数组中查找数字I {

	//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
	public int search(int[] nums, int target) {
		return binarySearch(nums,target) - binarySearch(nums, target -1);
    }
	
	public int binarySearch(int[] nums,int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = (right + left) >> 1;
			int midVal = nums[mid];
			if(midVal <= target) {
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		return left;
	}
	
	public int search01(int[] nums, int target) {
		int count = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == target) {
				count++;
			}
		}
		return count;
    }
	
	
	
	public static void main(String[] args) {
		int[] arr = {5,7,8,8,8,10};
		剑指Offer_53_I_在排序数组中查找数字I test = new 剑指Offer_53_I_在排序数组中查找数字I();
		
		System.out.println(test.search(arr,9));
	}

}
