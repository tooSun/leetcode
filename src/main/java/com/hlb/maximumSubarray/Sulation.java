package com.hlb.maximumSubarray;

/**
 * 最大子序和
 *
 * @author hlb
 * @date 2020/10/21 16:45
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] nums = {-2,1,0,1,1};

		System.out.println(f1(nums));

	}

	/**
	 * 动态规划
	 *
	 * @param nums
	 * @return
	 */
	public static int f1(int[] nums) {
		int pre = 0, ans = nums[0];
		for (int i : nums) {
			pre = Math.max(pre + i, i);
			ans = Math.max(pre, ans);
		}
		return ans;
	}

}
