package com.hlb.romanToInteger;

/**
 *
 *
 * @author hlb
 * @date 2020/9/23 16:24
 *
 */
public class Sulation {

	public static void main(String[] args) {

		String s = "I";

		System.out.println(f1(s));

	}

	public static int f1(String s) {
		if(null == s || s.length() == 0) {
			return 0;
		}

		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = choose(s.charAt(i));
			if(i + 1 < s.length() && num < choose(s.charAt(i + 1))) {
				total -= num;
			} else {
				total += num;
			}
		}

		return total;
	}

	public static int choose(char s) {
		switch (s) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

}
