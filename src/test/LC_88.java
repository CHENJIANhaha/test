package test;

import java.util.ArrayList;
import java.util.List;

public class LC_88 {
	public static void main(String arg[]) {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
//		int[] temp = merge(nums1, nums2, 3, 3);
		merge2(nums1, 3, nums2, 3);
		List<Integer> list = new ArrayList<>();
		for(int num: nums1) {
			list.add(num);
		}
		System.out.println(list);

	}
	
	public static int[] merge(int[] nums1, int[] nums2, int m, int n) {
		int i = 0;
        int j = 0;
        int t = 0;
        int[] temp = new int[m+n];
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                temp[t++] = nums1[i++];
            }else {
                temp[t++] = nums2[j++];
            }
        }
        
        while(i<m) {
            temp[t++] = nums1[i++];
        }
        
        while(j<n) {
            temp[t++] = nums2[j++];
        }
        
        nums1 = temp;
        return nums1;
	}
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while(i < m + n && j < n) {
            if(nums1[i] > nums2[j]) {
                for(int k = m+n-1; k > i; k-- ) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
            }else {
                i++;
            }
        }
    }
}
