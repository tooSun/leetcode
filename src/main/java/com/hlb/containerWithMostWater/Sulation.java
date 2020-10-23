package com.hlb.containerWithMostWater;

/**
 * 盛最多水的容器
 *
 * @author hlb
 * @date 2020/10/22 19:32
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] height = new int[]{2,22};

		System.out.println(f1(height));

	}

	/**
	 * 双指针
	 *
	 * @param height
	 * @return
	 */
	public static int f1(int[] height) {

		int p = 0, q = height.length - 1;
		int max = 0;
		while (p < q) {
			int v = (q - p) * Math.min(height[p], height[q]);
			max = Math.max(max, v);
			if(height[p] > height[q]) {
				q --;
			} else {
				p ++;
			}
		}

		return max;
	}

}
