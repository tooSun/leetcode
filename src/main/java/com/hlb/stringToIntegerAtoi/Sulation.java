package com.hlb.stringToIntegerAtoi;

/**
 * 字符串转换整数 (atoi)
 *
 * @author hlb
 * @date 2020/10/22 11:46
 *
 */
public class Sulation {

	public static void main(String[] args) {

		String s = "-91283472332";

		System.out.println(f1(s));

	}

	/**
	 * 自动机
	 *
	 * @param s
	 * @return
	 */
	public static int f1(String s) {
		Automaton automaton = new Automaton();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			automaton.get(s.charAt(i));
		}

		return (int) (automaton.sigend * automaton.ans);
	}

}
