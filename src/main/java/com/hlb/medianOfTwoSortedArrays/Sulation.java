package com.hlb.medianOfTwoSortedArrays;

/**
 * 寻找两个正序数组的中位数
 *
 * @author hlb
 * @date 2020/10/20 14:40
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] nums1 = {1,3,4,9};
		int[] nums2 = {1,2,3,4};

//		System.out.println(f1(nums1, nums2));

		System.out.println(f2(nums1, nums2));

	}

	/**
	 * 自解-暴力，将数组合并再计算中位数
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double f1(int[] nums1, int[] nums2) {
		if(null == nums1 || null == nums2) {
			return 0d;
		}
		int[] dummy = new int[nums1.length + nums2.length];
		int n = dummy.length - 1;
		int i = nums1.length;
		int j = nums2.length;
		while (i != 0 || j != 0) {
			if(i != 0 && j != 0) {
				if(nums1[i - 1] > nums2[j - 1]) {
					dummy[n] = nums1[i - 1];
					n--;
					i--;
				} else {
					dummy[n] = nums2[j - 1];
					n--;
					j--;
				}
			} else if(i == 0) {
				dummy[n] = nums2[j - 1];
				n--;
				j--;
			} else if(j == 0) {
				dummy[n] = nums1[i - 1];
				n--;
				i--;
			}
		}

		n = dummy.length;
		if(n % 2 == 0) {
			return (dummy[n / 2 - 1] + dummy[n / 2]) / 2d;
		} else {
			return dummy[n / 2];
		}
	}

	/**
	 * 二分法
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double f2(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int totalLen = len1 + len2;
		if(totalLen % 2 == 0) {
			return (getElement(nums1, nums2, totalLen / 2) + getElement(nums1, nums2, totalLen / 2 + 1)) / 2d;
		} else {
			return getElement(nums1, nums2, totalLen / 2 + 1);
		}
	}

	public static int getElement(int[] nums1, int[] nums2, int k) {
		int index1 = 0, index2 = 0;
		int len1 = nums1.length, len2 = nums2.length;

		while(true) {
			if(index1 == len1) {
				return nums2[index2 + k - 1];
			}
			if(index2 == len2) {
				return nums1[index1 + k - 1];
			}
			if(k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			int half = k / 2;
			int newIndex1 = Math.min(index1 + half, len1) - 1;
			int newIndex2 = Math.min(index2 + half, len2) - 1;
			int v1 = nums1[newIndex1], v2 = nums2[newIndex2];
			if(v1 <= v2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}

}
