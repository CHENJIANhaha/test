package test;

import java.util.Arrays;
import java.util.HashMap;

//������3���������ظ�������
public class Offer_3 {
	public static void main(String arg[]) {
		int[] nums = {1, 3, 1, 0, 2, 5, 3};
		int[] nums2 = {2, 3, 5, 4, 3, 2, 6, 7};
		System.out.println(findSameNumber(nums));
		System.out.println(findSameNumber2(nums));
		System.out.println(findSameNumber3(nums));
		System.out.println(findSameNumber4(nums2));
	}
	
	// ����1��Ԥ����
	public static int findSameNumber(int[] nums) {
		//������������������ʱ�临�Ӷ�Ϊ O(nlog(n))
		Arrays.sort(nums);
		//ָ��ָ�������еĵ�һ����
		int num = nums[0];
		//�������飬��ָ���뵱ǰ���ֲ���ȣ���ָ��ָ��ǰ����
		for(int i=1; i<nums.length-1; i++) {
			if(nums[i] != num) {
				num = nums[i];
			}else {
				return num;
			}
		}
		return -1;
	}
	
	// ����2����ϣ��
	public static int findSameNumber2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num: nums) {
			//�жϹ�ϣ�����Ƿ��Ѿ���Ź���ǰ����
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				return num;
			}
		}
		return -1;
	}
	
	// ����3������
	public static int findSameNumber3(int[] nums) {
		//�ж������Ƿ�Ϸ�
		if(nums == null || nums.length <=0) {
			return -1;
		}
		
		//�ж������е������Ƿ�Ϸ����Ƿ��� 0~n-1 ֮�䣬n Ϊ���ֳ���
		for(int num: nums) {
			if(num <0 || num > nums.length-1) {
				return -1;
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			//�жϵ�ǰ�����Ƿ�����λ����ƥ�䣬����ƥ�䣬�򽫵�ǰ���������Ӧλ���ϵ����ֽ��н���
			while(nums[i] != i) {
				if(nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}
		
		return -1;
	}
	
	// ����4�����ֲ���
	public static int findSameNumber4(int[] nums) {
		if(nums == null || nums.length <= 0) {
			return -1;
		}
		
		for(int num: nums) {
			if(num <0 || num > nums.length-1) {
				return -1;
			}
		}
		
		int start = 1;
		int end = nums.length - 1;
		while(start <= end) {
			int mid = (end - start)/2 + start;
			int count = countRange(nums, start, mid);
			
			if(start == end) {
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			
			if(count > (mid - start + 1)) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static int countRange(int[] nums, int start, int end) {
		int count = 0;
		for(int num: nums) {
			if(num >= start && num <= end) {
				count++;
			}
		}
		return count;
	}
}
