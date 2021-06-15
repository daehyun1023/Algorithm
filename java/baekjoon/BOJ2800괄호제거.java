package DataStructure;
import java.util.*;
import java.io.*;
public class BOJ2800괄호제거 {

	static String str;
	static ArrayList<Integer> left = new ArrayList<Integer>();
	static ArrayList<Integer> right = new ArrayList<Integer>();
	static int size;
	static boolean[] check;
	static ArrayList<String> result = new ArrayList<String>();
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void combination(int depth, int x) {
		if(depth >= 1 && depth <= size) {
			StringBuilder sb = new StringBuilder();
			ArrayList<Integer> remove = new ArrayList<Integer>();
			
			for(int i=0; i<size; i++) {
				if(check[i]) {
					remove.add(left.get(i));
					remove.add(right.get(i));
				}
			}
			
			for(int i=0,strSize=str.length(); i<strSize; i++) {
				if(remove.contains(i)) {
					continue;
				}
				sb.append(str.charAt(i));
			}
			
			result.add(sb.toString());
			
			if(depth == size) {
				return;
			}
		}
		
		for(int i=x; i<size; i++) {
			if(!check[i]) {
				check[i] = true;
				combination(depth+1, i);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		for(int i=0,size=str.length(); i<size; i++) {		
			if(str.charAt(i) == '(') {
				stack.add(i);
			} else if(str.charAt(i) == ')') {
				left.add(stack.pop());
				right.add(i);
			}
		}
		
		size = left.size();
		check = new boolean[size];
		
		combination(0,0);
		
		Collections.sort(result);
		String prev = "";
		
		for(String res: result) {
			if(!prev.equals(res)) {
				System.out.println(res);
				prev = res;
			}
		}
	}
	
}