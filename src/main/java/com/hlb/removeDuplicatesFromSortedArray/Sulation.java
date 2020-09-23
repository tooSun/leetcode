package com.hlb.removeDuplicatesFromSortedArray;

/**
 * 删除排序数组中的重复项
 *
 * @author hlb
 * @date 2020/9/21 19:27
 *
 */
public class Sulation {

	public static void main(String[] args) {

		System.out.println(f1(new int[]{1, 1, 1, 2}));

	}

	public static int f1(int[] nums) {

		if(null == nums || nums.length == 0) {
			return 0;
		}

		int i = 0;
		for(int j = 1; j < nums.length; j++) {
			if(nums[i] != nums[j]) {
				i ++;
				nums[i] = nums[j];
			}
		}

		return i + 1;
	}

}
