package com.tassel.search;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author shuaiyin.zhang
 * @description 二分查找算法
 * @date 2020/07/24
 */
public class BinarySearch {
	/**
	 * 本例来自 《算法》第四版 1.1.10
	 * 数组必须是有序的
	 */
	private static final Logger logger = Logger.getLogger("BinarySearch");

	public static int rank(int target, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (target < a[mid]) {
				// 目标在左半部分
				hi = mid - 1;
			} else if (target > a[mid]) {
				// 目标在右半部分
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * test
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 7, 13, 35, 44, 89};
		int target = 13;
		// 保证有序
		Arrays.sort(a);
		int t = rank(target, a);
		if (t == -1) {
			logger.info(target + " 不在数组内. ");
		} else {
			logger.info(target + " 在数组索引为 " + t + " 的位置. ");
		}
	}
}
