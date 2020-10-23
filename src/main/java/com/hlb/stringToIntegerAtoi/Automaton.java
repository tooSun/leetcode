package com.hlb.stringToIntegerAtoi;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author hlb
 * @date 2020/10/22 14:22
 *
 */
public class Automaton {

	public int sigend = 1;
	private String state = "start";
	public long ans = 0;
	private Map<String, String[]> table = new HashMap<String, String[]>() {{
		put("start", new String[] {"start", "signed", "in_number", "end"});
		put("signed", new String[] {"end", "end", "in_number", "end"});
		put("in_number", new String[] {"end", "end", "in_number", "end"});
		put("end", new String[] {"end", "end", "end", "end"});
	}};

	public void get(char c) {
		state = table.get(state)[getState(c)];
		if ("in_number".equals(state)) {
			ans = ans * 10 + c - '0';
			ans = sigend == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
		}
		else if ("signed".equals(state)) {
			sigend = c == '-' ? -1 : 1;
		}
	}

	public int getState(char c) {
		if (c == ' ') {
			return 0;
		}
		else if (c == '+' || c == '-') {
			return 1;
		}
		else if (Character.isDigit(c)) {
			return 2;
		}

		return 3;
	}

}
