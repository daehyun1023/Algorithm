package TwoPointer;
import java.util.*;
import java.io.*;
public class BOJ2473세용액 {

	static int N;
	static long[] arr;
	static long max = 3000000000L;
	static long[] pick = new long[3];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		
	}

}
