package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 38. ±¨Êý
public class LC_38 {
	public static void main(String arg[]) {
		System.out.println(countAndSay(4));
	}
	
	public static String countAndSay(int n) {
		String result = "1";
 		for(int i=1; i<n; i++) {
 			System.out.println(result);
 			result = say(result);
 		}
		return result;
	}
	
	public static String say(String str) {
		int count = 1;
        StringBuilder sb = new StringBuilder();
        char cur = str.charAt(0);
        for(int j=1; j<str.length(); j++) {
        	char c = str.charAt(j);
            if(c != cur) {
               sb.append(count);
               sb.append(cur);
               cur = c;
               count = 1;                       
            }else {
               count++;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
	}
}
