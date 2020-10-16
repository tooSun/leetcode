package com.hlb.removeElement;

/**
 * 移除元素
 *
 * @author hlb
 * @date 2020/10/16 14:06
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] nums = {2};
		int val = 2;
		System.out.println(f1(nums, val));

	}

	/**
	 * 双指针法
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int f1(int[] nums, int val) {

		if(null == nums) {
			return 0;
		}

		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != val) {
				nums[i] = nums[j];
				i ++;
			}
		}

		return i;
	}

}
