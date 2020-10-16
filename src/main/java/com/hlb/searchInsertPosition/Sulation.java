package com.hlb.searchInsertPosition;

/**
 * 搜索插入位置
 *
 * @author hlb
 * @date 2020/10/16 11:34
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] nums = {1,3,5,6};
		int target = 0;
		System.out.println(f2(nums, target));

	}

	/**
	 * 暴力破解
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int f1(int[] nums, int target) {

		if(null == nums) {
			return 0;
		}

		int len = nums.length;

		for(int i = 0; i < len; i++) {
			if(nums[i] == target) {
				return i;
			} else if(0 == i && nums[i] > target) {
				return i;
			} else if(i + 1 == len && nums[i] < target) {
				return i + 1;
			} else if(nums[i] < target && nums[i + 1] > target && i + 1 < len) {
				return i + 1;
			}
		}

		return 0;

	}

	/**
	 * 二分法
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int f2(int[] nums, int target) {
		if(null == nums) {
			return 0;
		}

		int len = nums.length;
		int left = 0, right = len - 1, mid = 0, ans = len;
		while(left <= right) {
			mid = ((right - left) >> 1) + left;
			if(nums[mid] >= target) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

}
