package test;

// 堆排
public class Heap<T extends Comparable<T>> {
	
	private T[] heap;
	private int N = 0;
	
	public Heap(int maxN) {
		this.heap = (T[]) new Comparable[maxN + 1];
	}
	
	// 返回堆的大小
	public int size() {
		return N;
	}
	
	// 判断堆是否为空
	public boolean isEmpty() {
		return N == 0;
	}
	
	// 比较堆中两个数的大小
	public boolean less(int i, int j) {
		return heap[i].compareTo(heap[j]) < 0;
	} 
	
	// 交换堆中的两个数
	public void swap(int i, int j) {
		T t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}
	
	// 上浮：当前节点大于其根节点时
	public void swim(int k) {
		while(k/2 >=1 && less(k/2, k)) {
			swap(k/2, k);
			k = k/2;
		}
	}
	
	// 下沉：当前节点小于其子节点时
	public void sink(int k) {
		while(k*2 <= N) {
			int j = k*2;
			// 找到最大子节点的位置
			if(j<N && less(j, j+1)) {
				j++;
			}
			// 当前节点大于其最大子节点
			if(!less(k, j)) break;
			
			swap(k, j);
			k = j;
		}
	}
	
	// 插入新节点
	public void insert(T v) {
		heap[++N] = v;
		swim(N);
	}
	
	// 删除最大元素并返回
	public T delMax() {
		T max = heap[1];
		swap(1, N--);
		heap[N+1] = null;
		sink(1);
		return max;
	}
	
	public void sink(T[] nums, int k, int N) {
		while(k*2 <= N) {
			int j = k*2;
			// 找到最大子节点的位置
			if(j<N && less(nums, j, j+1)) {
				j++;
			}
			// 当前节点大于其最大子节点
			if(!less(nums, k, j)) break;
			
			swap(nums, k, j);
			k = j;
		}
	}
	
	public boolean less(T[] nums, int i, int j) {
		return nums[i].compareTo(nums[j]) < 0;
	} 
	
	public void swap(T[] nums, int i, int j) {
		T t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	public void sort(T[] nums) {
		int n = nums.length - 1;
		for(int i = n/2; i >= 1; i--) {
			sink(nums, i, n);
		}
		
		while(n > 1) {
			swap(nums, 1, n--);
			sink(nums, 1, n);
		}
	}
}
