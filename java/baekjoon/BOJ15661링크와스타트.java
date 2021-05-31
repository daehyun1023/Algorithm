import java.util.*;
public class BOJ15661링크와스타트 {

	static int N;
	static int M;
	static int[][] arr;
	static boolean[] check;
	static int result=Integer.MAX_VALUE;
	static ArrayList<Integer> start=new ArrayList();
	static ArrayList<Integer> link=new ArrayList();
	
	public static void btr(int a,int x,int depth) {
		if(depth==a) {
			int startsum=0;
			int linksum=0;
			start.clear();
			link.clear();
			
			for(int i=0;i<N;i++) {
				if(check[i]) {
					start.add(i);
				}
				else {
					link.add(i);
				}
			}
			
			
			for(int i=0;i<start.size();i++) {
				for(int j=0;j<start.size();j++) {
					startsum+=arr[start.get(i)][start.get(j)];
				}
			}
			
			for(int i=0;i<link.size();i++) {
				for(int j=0;j<link.size();j++) {
					linksum+=arr[link.get(i)][link.get(j)];
				}
			}
			
			result=Math.min(result, Math.abs(linksum-startsum));
		
			return;
			
		}
		
		for(int i=x;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				btr(a,i,depth+1);
				check[i]=false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		M=N/2;
		check=new boolean[N];
		
		for(int i=1;i<=M;i++) {
			btr(i,0,0);
		}
		
		System.out.println(result);
		
	}

}
