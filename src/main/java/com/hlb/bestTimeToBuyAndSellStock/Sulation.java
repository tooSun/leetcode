package com.hlb.bestTimeToBuyAndSellStock;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 买卖股票的最佳时机
 *
 * @author hlb
 * @date 2020/10/19 19:52
 *
 */
public class Sulation {

	public static void main(String[] args) {

		int[] prices = {7,1,5,3,6,4};

		int maxVal = f2(prices);

		System.out.println(maxVal);

	}

	/**
	 * 一次遍历
	 *
	 * @param prices
	 * @return
	 */
	public static int f1(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			} else if(prices[i] - min > max) {
				max = prices[i] - min;
			}
		}

		return max;
	}

	/**
	 * 暴力破解
	 *
	 * @param prices
	 * @return
	 */
	public static int f2(int[] prices) {
		int maxVal = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if(maxVal < prices[j] - prices[i]) {
					maxVal = prices[j] - prices[i];
				}
			}
		}
		return maxVal;
	}

}
