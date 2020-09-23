package com.hlb.sortedMergeLcci;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 合并排序数组
 *
 * @author hlb
 * @date 2020/9/21 20:15
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] A = new int[]{1,2,3,0,0,0};
		f2(A, 3, new int[]{2,5,6}, 3);
//		int[] A = new int[]{0};
//		f2(A, 0, new int[]{1}, 1);
		System.out.println(Arrays.toString(A));

	}

	/**
	 * 双指针法
	 *
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public static void f1(int[] A, int m, int[] B, int n) {

		int[] C = new int[m + n];

		int pa = 0;
		int pb = 0;

		while(pa < m || pb < n) {
			if(pa == m) {
				C[pa + pb] = B[pb];
				pb ++;
			} else if(pb == n) {
				C[pa + pb] = A[pa];
				pa ++;
			} else if(A[pa] < B[pb]) {
				C[pa + pb] = A[pa];
				pa ++;
			} else {
				C[pa + pb] = B[pb];
				pb ++;
			}
		}

		for (int i = 0; i < C.length; i++) {
			A[i] = C[i];
		}

	}

	/**
	 * 逆向双指针法
	 *
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public static void f2(int[] A, int m, int[] B, int n) {

		int pa = m - 1;
		int pb = n - 1;
		int tail = m + n -1;

		while(tail >= 0) {
			if(pa == -1) {
				A[tail] = B[pb];
				pb --;
			} else if(pb == -1) {
				A[tail] = A[pa];
				pa --;
			} else if(A[pa] > B[pb]) {
				A[tail] = A[pa];
				pa --;
			} else {
				A[tail] = B[pb];
				pb --;
			}
			tail --;
		}

	}

}
