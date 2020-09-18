package com.hlb.palindromeNumber;

/**
 * 回文数判断
 *
 * @author hlb
 * @date 2020/9/7 19:25
 *
 */
public class Sulation {

	public static void main(String[] args) {

		System.out.println(f1(0));

//		System.out.println(12 >>> 1);
	}

	public static boolean f1(int x) {
		if(x < 0 || (x % 10 == 0 && x > 0)) {
			return false;
		}

		int r = 0;

		while(x > r) {
			r = r * 10 + x % 10;
			x = x / 10;
		}

		return x == r || x == r / 10;
	}

}
