package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1.两数之和
 *
 */
public class LC_TwoSum {
	public static void main(String args[]) throws IOException {
		int number = 0;
		int target = 0;
		int[] result1 = new int[2];
		int[] result2 = new int[2];
		int[] result3 = new int[2];
		System.out.println("请输入要输入数组的大小：");
		Scanner in_number = new Scanner(System.in);
		number = in_number.nextInt();
		int[] array = new int[number];
		System.out.println("请输入整数数组：");
		Scanner in_array = new Scanner(System.in);
		for(int i = 0; i < number; i++) {
			array[i] = in_array.nextInt();
		}
		System.out.println("请输入目标值：");
		Scanner in_target = new Scanner(System.in);
		target = in_target.nextInt();
		result1 = twoSum(array, target);
		result2 = twoSumMapTwice(array, target);
		result3 = twoSumMapOnce(array, target);
		System.out.println("结果1：");
		for(int i = 0; i < 2; i++) {
			System.out.println(result1[i]);
		}
		System.out.println("结果2：");
		for(int i = 0; i < 2; i++) {
			System.out.println(result2[i]);
		}
		System.out.println("结果3：");
		for(int i = 0; i < 2; i++) {
			System.out.println(result3[i]);
		}

	}
	
	/*暴力算法：两次循环遍历数组,时间复杂度O(n2),空间复杂度O(1)*/
	public static int[] twoSum(int[] nums, int target) {
        int a = 0, b = 0, c = 0;
        int[] result;
        result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            a = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                b = nums[j];
                c = a + b;
                if(c==target) {
                	result[0] = i;
                	result[1] = j;
                	return result;
                }
            }
        }throw new IllegalArgumentException("No two sum solution");
    }
	
	/*两遍哈希表：时间复杂度O(n),空间复杂度O(n)*/
	public static int[] twoSumMapTwice(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<> ();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++) {
			int left = target - nums[i];
			if(map.containsKey(left) && map.get(left) != i) {
				return new int[] {i, map.get(left)};
			}
		}throw new IllegalArgumentException("No two sum solution");
	}
	
	/*一遍哈希表：时间复杂度O(n),空间复杂度O(n)*/
	public static int[] twoSumMapOnce(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<> ();
		for(int i = 0; i < nums.length; i++) {
			int left = target - nums[i];
			if(map.containsKey(left)) {
				return new int[] {map.get(left), i};
			}
			map.put(nums[i], i);//先判断是否存在对应元素再将元素插入表中，防止对应元素为插入元素本身情况的出现
		}throw new IllegalArgumentException("No two sum solution");
	}
}
