package TwoPointer;

import java.util.*;
import java.io.*;

public class BOJ2467용액 {

	static int pick1 = -1;
	static int pick2 = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		int max = 2000000000;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < max) {
				pick1 = arr[left];
				pick2 = arr[right];
				max = Math.abs(sum);
			}
			
			if(sum > 0) {
				right--;
			}
			else {
				left++;
			}
			
		}
		
		System.out.println(pick1 + " " + pick2);
		
	}

}
