package com.zsy.sort;

/**
 * @author shuaiyin.zhang
 * @description 希尔排序(算法 第四版)
 * @date 2020/07/29
 */
public class Shell implements Example {
	/**
	 * 希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的。这样的数组被称为 h 有序数组。
	 * 一个 h 有序数组 即一个由 h 个有序子数组组成的数组.
	 * [8,9,1,7,2,3,5,4,6,0]
	 * h = 1 < 10 / 3 => h = 3 * 1 + 1 = 4
	 * i=4; a[i], a[i-4] i++;
	 * [2,3,1,4,8,9,5,7,6,0]
	 * <p>
	 * h = 4 / 3 = 1
	 *
	 * @param a 需要排序的数组
	 */
	@Override
	public void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			// 将数组变成 h 有序
			System.out.println("h: " + h);
			for (int i = h; i < n; i++) {
				// 将 a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h] ... 之中
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					System.out.println(a[j] + "<--->" + a[j - h]);
					exchange(a, j, j - h);
					show(a);
				}
			}
			h = h / 3;
		}
	}

	public static void main(String[] args) {
		//String[] a = new String[]{"S", "H", "E", "L", "L", "E", "X", "A", "M", "P", "L", "E"};
		Integer[] a = new Integer[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		Shell shell = new Shell();
		shell.sort(a);
		assert shell.isSorted(a);
		shell.show(a);
		shell.exchange(a, 3, 5);
		shell.show(a);
	}
}
