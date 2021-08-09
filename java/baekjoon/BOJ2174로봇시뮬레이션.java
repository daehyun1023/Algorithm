import java.util.*;

public class Main {
	
	static class Pair{
		int x;
		int y;
		int d;
		Pair(int x,int y,int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
	static int A;
	static int B;
	static int[][] arr;
	static int N;
	static int M;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static ArrayList<Pair> robot=new ArrayList();
	static boolean flag=false;
	static int result=0;
	
	public static void solve(int num,String go,int iter) {
		
		if(flag) {
			return;
		}
		
		for(int it=0;it<iter;it++) {
			if(go.equals("L")) {
				robot.get(num-1).d=(robot.get(num-1).d+3)%4;
			}
			
			else if(go.equals("R")) {
				robot.get(num-1).d=(robot.get(num-1).d+1)%4;
			}
			else {
				
				int nx=robot.get(num-1).x+dx[robot.get(num-1).d];
				int ny=robot.get(num-1).y+dy[robot.get(num-1).d];
				
				
				if(nx<0 || ny<0 || nx>=A || ny>=B) {
					flag=true;
					System.out.println("Robot"+" "+num+" "+"crashes into the wall");
					return;
				}
				if(arr[nx][ny]!=0) {
					flag=true;
					System.out.println("Robot"+" "+num+" "+"crashes into robot"+" "+arr[nx][ny]);
					return;
				}
				
				arr[nx][ny]=arr[robot.get(num-1).x][robot.get(num-1).y];
				arr[robot.get(num-1).x][robot.get(num-1).y]=0;
				robot.get(num-1).x=nx;
				robot.get(num-1).y=ny;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		B=sc.nextInt();
		A=sc.nextInt();
		arr=new int[A][B];
		N=sc.nextInt();
		M=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			String s=sc.next();
			int c;
			if(s.equals("W")) {
				c=3;
			}
			else if(s.equals("E")) {
				c=1;
			}
			else if(s.equals("N")) {
				c=0;
			}
			else {
				c=2;
			}
			arr[A-b][a-1]=i+1;
			robot.add(new Pair(A-b,a-1,c));
			
		}
		
		for(int i=0;i<M;i++) {
			solve(sc.nextInt(),sc.next(),sc.nextInt());
		}
		
		if(flag==false) {
			System.out.println("OK");
		}
		
	}

}
