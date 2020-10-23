package com.hlb.sumFor3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 三数之和
 *
 * @author hlb
 * @date 2020/10/23 10:53
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] nums = new int[]{0,0,0};

		List<List<Integer>> list = f1(nums);

		list.stream().forEach(l -> {
			l.stream().forEach(i -> System.out.print(i + ","));
			System.out.println();
		});

	}

	/**
	 * 排序 + 双指针
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> f1(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if(nums.length < 3) {
			return list;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i ++) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int k = nums.length - 1;
			for (int j = i + 1; j < nums.length - 1; j ++) {
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				while(j < k && nums[j] + nums[k] > -nums[i]) {
					k --;
				}
				if(j == k) {
					continue;
				}
				if(nums[i] + nums[j] + nums[k] == 0) {
					list.add(Arrays.asList(nums[i], nums[j], nums[k]));
				}
			}
		}

		return list;
	}

}
