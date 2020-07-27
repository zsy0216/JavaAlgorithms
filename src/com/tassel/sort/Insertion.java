package com.tassel.sort;

/**
 * @author shuaiyin.zhang
 * @description 插入排序(算法 第四版)
 * @date 2020/07/27
 */
public class Insertion implements Example {
	@Override
	public void sort(Comparable[] a) {
		// 将 a[] 按升序排列
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exchange(a, j, j - 1);
			}
		}
	}

	public static void main(String[] args) {
		String[] a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		Insertion insertion = new Insertion();
		insertion.sort(a);
		assert insertion.isSorted(a);
		insertion.show(a);
		insertion.exchange(a, 3, 5);
		insertion.show(a);
	}
}
