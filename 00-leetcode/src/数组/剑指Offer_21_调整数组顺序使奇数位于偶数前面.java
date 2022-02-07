package 数组;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 */
public class 剑指Offer_21_调整数组顺序使奇数位于偶数前面 {
	
	public int[] exchange(int[] nums) {
		int left = 0;
		int right = nums.length -1;
		while(left < right) {
			if((nums[left] & 1) == 0) {// left 是偶数
				if((nums[right] & 1) == 1) {// right是奇数
					int temp = nums[left];
					nums[left] = nums[right];
					nums[right] = temp;
					left++;
					right--;
				}else {
					right--;
				}
			}else{
				left++;
			}
		}
		return nums;
    }
	
	public static void main(String[] args) {
//		int[] nums = {2,3,1,0,2,5,3};
		int[] nums = {1,2,3,4};
		剑指Offer_21_调整数组顺序使奇数位于偶数前面 test = new 剑指Offer_21_调整数组顺序使奇数位于偶数前面();
		test.exchange(nums);
		for(int num :nums) {
			System.out.print(num+" ");
		}
		
		System.out.println();
		int num = 4 & 1;
		System.out.println(num);
	}

}
