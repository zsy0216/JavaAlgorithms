package com.zsy.sort;

/**
 * @author shuaiyin.zhang
 * @description 选择排序(算法 第四版)
 * @date 2020/07/27
 */
public class Selection implements Example {
	@Override
	public void sort(Comparable[] a) {
		// 将 a[] 按升序排列
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exchange(a, i, min);
		}
	}

	public static void main(String[] args) {
		Selection selection = new Selection();
		String[] a = new String[]{"sad", "blue", "happy", "yellow", "passion", "red"};
		selection.sort(a);
		assert selection.isSorted(a);
		selection.show(a);
		selection.exchange(a, 2, 3);
		selection.show(a);
	}
}
