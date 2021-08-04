import java.util.*;


public class Main {

	static int N;
	static String[] str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		HashSet<String> set=new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(sc.next());
		}
		
		ArrayList<String> list=new ArrayList<String>(set);
		
		Collections.sort(list,new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				if(s1.length()>s2.length()) {
					return 1;
				}
				else if(s1.length()<s2.length()) {
					return -1;
				}
				
				else {
					return s1.compareTo(s2);
				}
				
			}
			
		});
		
		for(String s:list) {
			System.out.println(s);
		}
		
	}

}
