package com.hlb.reverseInteger;

/**
 * 整数反转
 *
 * @author hlb
 * @date 2020/9/7 17:44
 *
 */
public class Sulation {

	public static void main(String[] args) {

		System.out.println(f2(214748364));

	}

	/**
	 * y < Integer.MIN_VALUE / 10 和 y > Integer.MAX_VALUE / 10 主要做的是提前得知 当y乘10小于最小值或大于最大值 防止超出int域
	 *
	 * <br/>
	 *
	 * || 后面的逻辑，当y与Integer.MIN_VALUE / 10或Integer.MAX_VALUE / 10相等时，下一次加上x / 10，y是否小于最小值或大于最大值 防止超出int域
	 *
	 * @param x
	 * @return
	 */
	public static int f1(int x) {
		int y = 0;
		while (x != 0) {
			int pop = x % 10;
			if(y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10 )) {
				return 0;
			}
			if(y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10 )) {
				return 0;
			}
			y = y * 10 + pop;
			x = x / 10;
		}

		return y;
	}

	public static int f2(int x) {
		int y = 0;
		while (x != 0) {
			if((y * 10) / 10 != y) {
				y = 0;
				break;
			}
			y = y * 10 + x % 10;
			x = x / 10;
		}
		return y;
	}

}
