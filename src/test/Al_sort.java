package test;

import java.util.ArrayList;
import java.util.List;

public class Al_sort {
	
	// 快速排序中的截止范围
	static int CUTOFF = 10;
	
	public static void main(String arg[]) {
		int[] a = {34, 8, 5, 7, 1, 64, 51, 32, 21};
		bubbleSort(a);
		List<Integer> array = new ArrayList<Integer>();
		for(int num: a) {
			array.add(num);
		}
//		quickSort(array);
		System.out.println(array);
		
	}
	
	// 1、插入排序
	public static void insertionSort(int[] a) {
		int j;
		for(int i=1; i<a.length; i++) {
			int temp = a[i];
			for(j=i; j>0 && a[j-1] > temp; j--) {
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	
	// 2、希尔排序
	public static void shellSort(int[] a) {
		int j;
		// 增量序列采用 Shell 增量
		for(int gap = a.length / 2; gap > 0; gap /= 2) {
			for(int i = gap; i < a.length; i++) {
				int temp = a[i];
				for(j = i; j >= gap && a[j-gap] > temp; j -= gap) {
					a[j] = a[j - gap];
				}
				a[j] = temp;
			}
		}
	}
	
	// 3、归并排序的启动函数
	public static void mergeSort(int[] a) {
		int[] tempA = new int[a.length];
		mergeSort(a, tempA, 0, a.length - 1);
	}
	
	// 归并排序的递归函数
	public static void mergeSort(int[] a, int[] tempA, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, tempA, start, mid);
			mergeSort(a, tempA, mid + 1, end);
			merge(a, tempA, start, mid + 1, end);
		}
	}
	
	/**
	 * 归并排序的合并函数
	 * @param a 需要处理的数组
	 * @param tempA 临时数组
	 * @param leftPos 数组1的开始
	 * @param rightPos 数组2的开始
	 * @param rightEnd 数组2的结束
	 */
	public static void merge(int[] a, int[] tempA, int leftPos, int rightPos, int rightEnd) {
		// 待合并的数组1的尾部
		int leftEnd = rightPos - 1;
		// 临时数组的指针
		int tempPos = leftPos;
		// 合并的数据量
		int num = rightEnd - leftPos + 1;
		
		// 比较数据并将两个数据合并到临时数组中
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if(a[leftPos] < a[rightPos]) {
				tempA[tempPos++] = a[leftPos++];
			}else {
				tempA[tempPos++] = a[rightPos++];
			}
		}
		
		// 将数组前半部分剩余的数据拷贝到临时数组中
		while(leftPos <= leftEnd) {
			tempA[tempPos++] = a[leftPos++];
		}
		
		// 将数组后半部分剩余的数据拷贝到临时数组中
		while(rightPos <= rightEnd) {
			tempA[tempPos++] = a[rightPos++];
		}
		
		// 将临时数组中的数据拷贝到 原始数组中
		for(int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = tempA[rightEnd];
		}
	}
	
	// 4、快速排序简单实现
	public static void quickSort(List<Integer> list) {
		if(list.size() <= 1 || list == null) return;
		
		int compared = list.get(list.size() / 2);
		List<Integer> smaller = new ArrayList<>();
		List<Integer> same = new ArrayList<>();
		List<Integer> larger = new ArrayList<>();
		
		for(int num: list) {
			if(num < compared) {
				smaller.add(num);
			}else if(num > compared) {
				larger.add(num);
			}else {
				same.add(num);
			}
		}
		
		// 对小数集合和大数集合进行快排
		quickSort(smaller);
		quickSort(larger);
		
		list.clear();
		list.addAll(smaller);
		list.addAll(same);
		list.addAll(larger);
	}
	
	// 5、快排启动函数（优化后的快排）
	public static void QuickSort(int[] a) {
		QuickSort(a, 0, a.length - 1);
	}
	
	// 快排枢纽元定义函数
	public static int median3(int[] a, int left, int right) {
		int mid = (left + right) / 2;
		
		// 将三个元素按照从小到大的位置排列好
		if(a[left] > a[mid]) {
			swap(a, left, mid);
		}
		if(a[right] < a[mid]) {
			swap(a, mid, right);
		}
		if(a[left] > a[right]) {
			swap(a, left, right);
		}
		// 将枢纽元存放至倒数第二个位置，倒数第一个位置一定大于枢纽元，因此分割的时候不用考虑倒数第一个元素
		swap(a, mid, right-1);
		return a[right-1];
	}
	
	// 快排递归函数
	public static void QuickSort(int[] a, int left, int right) {
		// 待排数组大小在截止范围之内，选择快速排序，否则使用插入排序
		if((left + CUTOFF) <= right) {
			int pivot = median3(a, left, right);
			int l = left;
			int r = right - 1;
			for(;;) {
				while(a[++l] < pivot) {}
				while(a[--r] > pivot) {}
				if(l<r) {
					swap(a, l, r);
				}else {
					break;
				}
			}
			
			// 将枢纽元复位
			swap(a, l, right - 1);
			// 快排小数组
			QuickSort(a, left, l - 1);
			// 快排大数组
			QuickSort(a, r + 1, right);
		}else {
			insertionSort(a);
		}
	}
	
	// 6、选择排序
	public static void selectSort(int[] a) {
		for(int i = 0; i < a.length-1; i++) {
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, i, min);
		}
	}
	
	// 交换函数
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// 7、冒泡排序
	public static void bubbleSort(int[] a) {
		// 标记是否发生交换
		boolean isSorted = false;
		for(int i = a.length - 1; i > 0 && !isSorted; i--) {
			isSorted = true;
			for(int j = 0; j < i; j++) {
				if(a[j] > a[j + 1]) {
					isSorted = false;
					swap(a, j, j + 1);
				}
			}
		}
	}
	
}
