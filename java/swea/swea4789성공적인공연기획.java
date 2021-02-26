import java.util.*;
public class swea4789성공적인공연기획 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String str = sc.next();
			int result = 0;
			int totalCnt = 0;
			for(int i=0; i<str.length(); i++) {
				if(i > totalCnt) {
					result += (i-totalCnt);
					totalCnt += i-totalCnt;
				}
				int nowCnt = Integer.parseInt(str.substring(i, i+1));
				totalCnt += nowCnt;
			}
			
			System.out.println("#"+t+" "+result);
		}
		
	}

}
