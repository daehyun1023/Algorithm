import java.util.*;
import java.io.*;
public class BOJ2143두배열의합 {

	static long T, N, M, cnt;
	static long[] A, B;
	static ArrayList<Integer> sumA = new ArrayList();
	static ArrayList<Integer> sumB = new ArrayList();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N = sc.nextInt();
		A = new long[(int) N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		M = sc.nextInt();
		B = new long[(int) M];
		for(int i=0; i<M; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			int temp = (int) A[i];
			sumA.add(temp);
			for(int j=i+1; j<N; j++) {
				temp += A[j];
				sumA.add(temp);
			}
		}
		
		for(int i=0; i<M; i++) {
			int temp = (int) B[i];
			sumB.add(temp);
			for(int j=i+1; j<M; j++) {
				temp += B[j];
				sumB.add(temp);
			}
		}
		
		Collections.sort(sumA);
		Collections.sort(sumB);
		
		int leftA = 0;
		int rightB = sumB.size()-1;
		
		while(leftA < sumA.size() && rightB >= 0) {
			if(sumA.get(leftA) + sumB.get(rightB) < T) {
				leftA += 1;
			}
			else if(sumA.get(leftA) + sumB.get(rightB) > T){
				rightB -= 1;
			}
			else {
				int currA = sumA.get(leftA);
				int currB = sumB.get(rightB);
				int tmpA = leftA;
				int tmpB = rightB;
				long leftCnt = 0;
				long rightCnt = 0;
				while(tmpA < sumA.size() && currA == sumA.get(tmpA)) {
					leftCnt++;
					tmpA++;
				}
				while(tmpB >= 0 && currB == sumB.get(tmpB)) {
					rightCnt++;
					tmpB--;
				}
				
				cnt += (leftCnt) * (rightCnt);
				leftA = tmpA;
				rightB = tmpB;
				
			}
		}
		
		System.out.println(cnt);
		
	}

}
