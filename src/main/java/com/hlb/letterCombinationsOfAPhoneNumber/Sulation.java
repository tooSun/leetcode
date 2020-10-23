package com.hlb.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @author hlb
 * @date 2020/10/22 20:17
 *
 */
public class Sulation {



	public static void main(String[] args) {

		String digits = "23";

		List<String> list = f1(digits);

		list.stream().forEach(s -> System.out.print(s + " , "));

	}

	public static List<String> f1(String digits) {
		List<String> combinations = new ArrayList<>();
		if(digits.length() == 0) {
			return combinations;
		}
		Map<Character, String[]> table = new HashMap<Character, String[]>(){{
			put('2',new String[]{"a", "b", "c"});
			put('3',new String[]{"d", "e", "f"});
			put('4',new String[]{"g", "h", "i"});
			put('5',new String[]{"j", "k", "l"});
			put('6',new String[]{"m", "n", "o"});
			put('7',new String[]{"p", "q", "r", "s"});
			put('8',new String[]{"t", "u", "v"});
			put('9',new String[]{"w", "x", "y", "z"});
		}};

		backtrack(combinations, table, digits, 0, new StringBuffer());

		return combinations;
	}

	public static void backtrack(List<String> combinations, Map<Character, String[]> table, String digits, int index, StringBuffer sb) {
		if(index == digits.length()) {
			combinations.add(sb.toString());
		} else {
			String[] strings = table.get(digits.charAt(index));
			for(String s : strings) {
				sb.append(s);
				backtrack(combinations, table, digits, index + 1, sb);
				sb.deleteCharAt(index);
			}
		}
	}

}
