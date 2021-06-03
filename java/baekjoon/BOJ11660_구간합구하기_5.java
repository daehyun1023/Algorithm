package add;

import java.util.Scanner;
 
 
public class BOJ11660_구간합구하기_5 {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int N,M;
        int arr[][];
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        int dp[][];
        int sum[];
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        sum = new int[M];
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
        
        
        for(int k = 0; k < M; k++) {
    
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            
            sum[k] += dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
 
        }
        
        for(int k = 0; k < M; k++) {
        
            System.out.println(sum[k]);
        }
 
    }
 
}
