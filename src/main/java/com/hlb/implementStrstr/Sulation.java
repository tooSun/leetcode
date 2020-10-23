package com.hlb.implementStrstr;

/**
 * 实现 strStr()
 *
 * @author hlb
 * @date 2020/10/22 15:10
 *
 */
public class Sulation {


	public static void main(String[] args) {
		String haystack = "aaaaa";
		String needle = "bba";

		System.out.println(f2(haystack, needle));
	}

	/**
	 * 滑动窗口
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int f1(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if(len2 > len1) {
			return -1;
		}
		if(len1 == len2 && len1 == 0) {
			return 0;
		}
		for (int i = 0,j = 0; j < len1; i++) {
			j = i + len2;
			if(needle.equals(haystack.substring(i, j))) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 双指针
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int f2(String haystack, String needle) {
		int n = haystack.length();
		int l = needle.length();
		if(l == 0) {
			return 0;
		}

		int pn = 0;
		while(pn < n - l + 1) {
			while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) {
				pn ++;
			}

			int pl = 0;
			while (pl < l && pn < n && haystack.charAt(pn) == needle.charAt(pl)) {
				pn ++;
				pl ++;
			}

			if(pl == l) {
				return pn - l;
			}

			pn = pn - pl + 1;
		}

		return -1;
	}

}
