import java.io.*;

public class BOJ16637괄호추가하기 {

    static int N, ans = Integer.MIN_VALUE;
    static char[] s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();
        search(0, s[0]-'0');
        System.out.println(ans);
    }

    static void search(int i, int res) {
        if (i == N - 1) {
            ans = Math.max(ans, res);
            return;
        }

        search(i+2, calc(res, s[i+1], s[i+2]-'0'));
        if (i+2 < N-1) search(i+4, calc(res, s[i+1], calc(s[i+2]-'0', s[i+3], s[i+4]-'0')));
    }

    static int calc(int res, char op, int n) {
        if (op == '+') return res + n;
        else if (op == '-') return res - n;
        else return res * n;
    }
}