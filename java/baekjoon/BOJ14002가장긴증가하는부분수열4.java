import java.util.*;
import java.io.*;
public class BOJ14002가장긴증가하는부분수열4 {
	
	static int N;
	static int[] arr;
	static int[] LIS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		LIS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			LIS[i] = 1;
			for(int j=0; j<i; j++) {
				if( arr[j] < arr[i] ) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
			max = Math.max(max, LIS[i]);
		}
		System.out.println(max);
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=N-1; i>=0; i--) {
			if(LIS[i] == max) {
				stack.add(arr[i]);
				max--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
