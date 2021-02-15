import java.util.*;
import java.io.*;
public class BOJ3040일곱난장이 {

	static int[] arr = new int[9];
	static boolean end = false;
	
	public static void combination(int depth, int mask, int x, int sum) {
		
		if(end) return;
		if(depth == 7) {
			if(sum == 100) {
				for(int i=0; i<9; i++) {
					if((mask & 1<<i) !=0 ) {
						System.out.println(arr[i]);
					}
				}
				
				end = true;
				return;
			}
		}
		
		for(int i=x; i<9; i++) {
			if((mask & 1<<i) == 0) {
				combination(depth+1, mask|1<<i, i, sum+arr[i]);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0, 0, 0);
	}

}
