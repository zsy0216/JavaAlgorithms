package com.tassel.sort;

import java.util.logging.Logger;

/**
 * @author shuaiyin.zhang
 * @description 排序算法类的模板(算法 第四版)
 * @date 2020/07/27
 */
public class Example {
	private static final Logger logger = Logger.getLogger("Example");
	/**
	 * 一些排序算法的实现
	 */
	public static void sort(Comparable[] a) {
		// some implements
	}

	/**
	 * 对元素进行比较
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 将元素交换位置
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			logger.info(a[i] + " ");
		}
		logger.info("/n");
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = new String[]{"sad", "blue", "happy", "yellow"};
		sort(a);
		assert isSorted(a);
		exch(a, 2, 3);
		show(a);
	}
}
