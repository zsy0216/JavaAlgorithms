package com.zsy.sort;

/**
 * @author shuaiyin.zhang
 * @description 排序算法类的模板(算法 第四版)
 * @date 2020/07/27
 */
public interface Example {
	/**
	 * 一些排序算法的实现
	 *
	 * @param a 需要排序的数组
	 */
	void sort(Comparable[] a);

	/**
	 * 对元素进行比较
	 *
	 * @param v 元素
	 * @param w 元素
	 * @return 比较结果布尔值
	 */
	default boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 将元素交换位置
	 *
	 * @param a 数组
	 * @param i 交换索引
	 * @param j 交换索引
	 */
	default void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * 单行输出
	 *
	 * @param a 需要输出的数组
	 */
	default void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 判断数组是否有序
	 *
	 * @param a 需要判断的数组
	 * @return 是否有序 ? true : false
	 */
	default boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
