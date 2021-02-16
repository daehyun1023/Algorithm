import java.util.*;
import java.io.*;
public class jungol1828냉장고 {

	static class Ref implements Comparable<Ref>{
		int start, end;
		Ref(int start,int end){
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(Ref o) {
			int diff = this.end - o.end;
			return (diff!=0) ? diff : this.start-o.start;
		}
	}
	
	static int N;
	static Ref[] ref;
	static int result = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ref = new Ref[N];
		for(int i=0; i<N; i++) {
			ref[i] = new Ref(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(ref);
		int now = ref[0].end;
		for(int i=1, size=ref.length; i<size; i++) {
			if(now<ref[i].start) {
				now = ref[i].end;
				result++;
			}
		}
		
		System.out.println(result);
		
	}

}
