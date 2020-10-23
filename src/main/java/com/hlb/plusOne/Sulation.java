package com.hlb.plusOne;

import java.util.Arrays;

/**
 * 加一
 *
 * @author hlb
 * @date 2020/10/22 11:02
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] digits = new int[]{9};

		System.out.println(Arrays.toString(f1(digits)));

	}

	public static int[] f1(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if(digits[i] != 0) {
				return digits;
			}
		}

		digits = new int[digits.length + 1];
		digits[0] = 1;

		return digits;
	}

}
