package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//350.��������Ľ���2
public class LC_350 {
	public static void main(String arg[]) {
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {2,2,3};
		int[] result = interset3(nums1, nums2);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	// ����һ��ʹ�� list
	public static int[] interset(int[] nums1, int[] nums2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int num: nums1) {
			list1.add(num);
		}
		for(int num: nums2) {
			if(list1.contains(num)) {
				list2.add(num);
				//remove() ����ͨ�� Index �� Object ���ַ�ʽɾ�����ݣ�����ʹ�õ���ֱ��ɾ������
				list1.remove(Integer.valueOf(num));
			}
		}
		
		int[] result = new int[list2.size()];
		int i = 0;
		for(int num: list2) {
			result[i++] = num;
		}
		return result;
	}
	
	// ������������Ԥ����
	public static int[] interset2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> result = new ArrayList<>();
		for(int i=0, j=0; i<nums1.length && j<nums2.length;) {
			if(nums1[i] < nums2[j]) {
				i++;
			}
			else if(nums1[i] > nums2[j]) {
				j++;
			}
			else {
				result.add(nums1[i]);
				i++;
				j++;
			}
		}
		
		int[] res = new int [result.size()];
		int i = 0;
		for(int num: result) {
			res[i++] = num;
		}
		
		return res;
	}
	
	// ��������ʹ�� map
	public static int[] interset3(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(int num: nums1) {
			Integer count = map.get(num);
			if(count == null) {
				map.put(num, 1);
			}else {
				map.put(num, ++count);
			}
		}
		
		for(int num: nums2) {
			Integer count = map.get(num);
			if(count != null && count != 0) {
				result.add(num);
				map.put(num, --count);
			}
		}
		
		int[] res = new int[result.size()];
		int i = 0;
		for(int num: result) {
			res[i++] = num;
		}
		return res;
	}
}
