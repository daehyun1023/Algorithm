import java.util.Scanner;

public class BOJ10973 {
	       public static boolean pre_premutation(int[] arr, int s, int e){
		int i=e-1;
		for(; i>0; i--){
			if(arr[i]> arr[i-1])
				continue;
			else
				break;
		}
		if(i==0) return false;

		int j=e-1;
		for(; j>=i; j--){
			if(arr[j]>arr[i-1])
				continue;
			else
				break;
		}		
		//A[i-1], A[j] swap
		int tmp=arr[i-1];
		arr[i-1]=arr[j];
		arr[j]=tmp;

		j=e-1;
		while(i<j){
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++; j--;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] premutation=new int[N];
		for(int i=0; i<N; i++)
			premutation[i]=scan.nextInt();
		
		if(pre_premutation(premutation, 0, N)){
			for(int i=0; i<N; i++)
				System.out.print(premutation[i]+" ");
			System.out.println();
		}else
			System.out.println(-1);		
	}
}
