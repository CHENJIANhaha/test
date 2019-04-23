package test;

import java.util.HashSet;

// 217.�����ظ�Ԫ��
public class LC_217 {
	public static void main(String arg[]) {
		int[] nums = {1,2,3,4};
		System.out.println(containsDuplicate2(nums));
	}
	
	// ����һ���������
	public static boolean containsDuplicate(int nums[]) {
		int len = nums.length;
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	// ������������ HashSet ���ظ�������
	public static boolean containsDuplicate2(int nums[]) {
		HashSet hs = new HashSet();
		for(int i=0; i<nums.length; i++) {
			hs.add(nums[i]);
		}
		if(hs.size() < nums.length) {
			return true;
		}
		return false;
	}

}
