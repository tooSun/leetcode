package com.hlb.longestCommonPrefix;

/**
 * 最长公共前缀
 *
 * @author hlb
 * @date 2020/9/22 15:57
 *
 */
public class Sulation {

	public static void main(String[] args) {

		String[] strs = {"flower","flow","flight"};

		System.out.println(f4(strs));

	}

	/**
	 * 横向扫描
	 *
	 * @param strs
	 * @return
	 */
	public static String f1(String[] strs) {

		if(null == strs || strs.length == 0) {
			return "";
		}

		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int len = Math.min(s.length(), strs[i].length());
			int j = 0;
			for(; j < len; j++) {
				if(s.charAt(j) != strs[i].charAt(j)){
					break;
				}
			}
			s = strs[i].substring(0, j);
		}

		return s;
	}

	/**
	 * 纵向扫描
	 *
	 * @param strs
	 * @return
	 */
	public static String f2(String[] strs) {

		if(null == strs || strs.length == 0) {
			return "";
		}

		int len = strs[0].length();
		int count = strs.length;

		for (int i = 0; i < len; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; j++) {
				if(strs[j].length() < i + 1 || c != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}

		return strs[0];
	}

	/**
	 * 分治
	 *
	 * @param strs
	 * @return
	 */
	public static String f3(String[] strs) {
		if(null == strs || strs.length == 0) {
			return "";
		} else {
			return f3(strs, 0, strs.length - 1);
		}
	}

	public static String f3(String[] strs, int start, int end) {
		if(start == end) {
			return strs[start];
		} else {
			int mid = (end - start) / 2 + start;
			String left = f3(strs, start, mid);
			String right = f3(strs, mid + 1, end);
			return f3(left, right);
		}
	}

	public static String f3(String left, String right) {
		int len = Math.min(left.length(), right.length());
		for (int i = 0; i < len; i++) {
			if(left.charAt(i) != right.charAt(i)) {
				return left.substring(0, i);
			}
		}

		return left.substring(0, len);
	}

	/**
	 * 二分查找
	 *
	 * @param strs
	 * @return
	 */
	public static String f4(String[] strs) {
		if(null == strs || strs.length == 0) {
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		for(String s : strs) {
			minLen = Math.min(minLen, s.length());
		}

		int low = 0;
		int height = minLen;
		while(low < height) {
			int mind = (height - low + 1) / 2 + low;
			if(f4(strs, mind)) {
				low = mind;
			} else {
				height = mind - 1;
			}
		}

		return strs[0].substring(0, low);
	}

	public static boolean f4(String[] strs, int mind) {
		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			for (int j = 0; j < mind; j++) {
				if(s.charAt(j) != strs[i].charAt(j)) {
					return false;
				}
			}
		}

		return true;
	}

}
