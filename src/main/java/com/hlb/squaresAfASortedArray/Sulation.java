package com.hlb.squaresAfASortedArray;

import java.util.Arrays;

/**
 * 有序数组平方
 *
 * @author hlb
 * @date 2020/10/16 15:59
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] A = {-4,-1,0,3,10};

//		System.out.println(Arrays.toString(f1(A)));

		System.out.println(Arrays.toString(f2(A)));

	}

	/**
	 * 直接排序
	 *
	 * @param A
	 * @return
	 */
	public static int[] f1(int[] A) {
		if(null == A) {
			return null;
		}
		for(int i = 0; i < A.length; i++) {
			A[i] =A[i] * A[i];
		}
		Arrays.sort(A);
		return A;
	}

	public static int[] f2(int[] A) {
		if(null == A) {
			return null;
		}
		int navegate = -1;
		for(int i = 0; i < A.length; i++) {
			if(A[i] < 0) {
				navegate ++;
			} else {
				break;
			}
		}
		int i = navegate;
		int j = navegate + 1;
		int len = A.length;
		int[] ans = new int[len];
		int index = 0;
		while (i >= 0 || j < len) {
			if(i < 0) {
				ans[index] = A[j] * A[j];
				j ++;
			} else if(j == len) {
				ans[index] = A[i] * A[i];
				i --;
			} else if(Math.abs(A[i]) > Math.abs(A[j])) {
				ans[index] = A[j] * A[j];
				j ++;
			} else {
				ans[index] = A[i] * A[i];
				i --;
			}
			index ++;
		}

		return ans;
	}

}
