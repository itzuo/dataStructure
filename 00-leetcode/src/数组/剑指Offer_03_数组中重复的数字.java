package 数组;

import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class 剑指Offer_03_数组中重复的数字 {

	//哈希表 / Set
	public int findRepeatNumber01(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num :nums) {
			if(!set.add(num)) {
				return num;
			}
		}
		return -1;
    }
	
	/**
	 * 原地交换(https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/)
	 * 题目说明尚未被充分使用，即 在一个长度为n的数组nums里的所有数字都在0 ~ n-1的范围内。
	 * 此说明含义：数组元素的索引和值是一对多的关系。因此，可遍历数组并通过交换操作，使元素的索引与值
	 * 一一对应（即nums[i] = i)。因而，就能通过索引映射对应的值，起到与字典等价的作用。
	 */
	public int findRepeatNumber(int[] nums) {
		int i =0;
		while(i < nums.length) {
			if(nums[i] == i) {//说明此数字已在对应索引位置，无需交换，因此跳过；
				i++;
				continue;
			}
			//代表索引nums[i]处和索引i处的元素值都为nums[i],即找到一组重复值，返回此值nums[i]
			if(nums[nums[i]] == nums[i]) return nums[i];
			//否则交换索引为i和nums[i]的元素值，将此数字交换至对应索引位置。
			int tmp = nums[i];
			nums[i] = nums[tmp];
			nums[tmp] = tmp;
		}
		return -1;//若遍历完毕尚未返回，则返回-1
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 0, 2, 5, 3};
		剑指Offer_03_数组中重复的数字 test = new 剑指Offer_03_数组中重复的数字();
		System.out.println(test.findRepeatNumber(nums));
	}

}
