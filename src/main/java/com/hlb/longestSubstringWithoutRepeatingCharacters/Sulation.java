package com.hlb.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author hlb
 * @date 2020/9/3 20:04
 *
 */
public class Sulation {

	public static void main(String[] args) {

		String s = "abcabcbb";

		int ans = f1(s);

		System.out.println(ans);

	}

	/**
	 * 应用：滑动窗口
	 *
	 * @param s
	 * @return
	 */
	public static int f1(String s) {
		Set<Character> sc = new HashSet<>();
		int n = s.length();
		int rk = -1;
		int ans = 0;
		for (int i = 0; i < n; i ++) {
			if(i != 0) {
				sc.remove(s.charAt(i - 1));
			}
			while(rk + 1 < n && !sc.contains(s.charAt(rk + 1))) {
				sc.add(s.charAt(rk + 1));
				rk ++;
			}
			ans = Math.max(ans, rk - i + 1);
		}

		return ans;
	}

}
