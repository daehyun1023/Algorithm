package add;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1708블록껍질 {

	static class L{
		long x;
		long y;
		public L(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "L [x=" + x + ", y=" + y + "]";
		}
		
	}
	static class LC implements Comparator<L>{

		@Override
		public int compare(L p1, L p2) {
			int re=Long.compare(p1.y, p2.y);
			if(re==0) {
				return Long.compare(p1.x, p2.x);
			}else {
				return re;
			}
		}
		
	}
	
	//첫 시작점을 기준으로 정해진방향(여기서는 반시계)으로 정렬
	static class LTC implements Comparator<L>{

		L p0;
		public LTC(L p0) {
			this.p0 = p0;
		}

		@Override
		public int compare(L p1, L p2) {
			int re=ccw(p0,p1,p2);
			if(re==0) {
				long distance1 = dist(p0, p1);
                long distance2 = dist(p0, p2);

                if (distance1 > distance2) {    // 거리가 더 가까운 순으로 정렬
                    return 1;
                }else return -1;
			}else {
				return re>0 ? -1:1;// 반시계 방향인 경우가 먼저 오도록 한다
			}
		}
	}
	static int N;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		ArrayList<L> points=new ArrayList<>();
		Stack<L> hull=new Stack<>();
		
		//각 점의 좌표를 리스트에 저장
		for (int i = 0; i < N; i++) {
			long x=scann.nextLong();
			long y=scann.nextLong();
			points.add(new L(x,y));
		}
		//y좌표를 기준으로 정렬 -> 같으면 x좌표 기준 정렬 : 가장 외부에 있는 점을 하나 선택하기 위해서
		points.sort(new LC());
		//처음 시작할 점의 좌표
		L p0=points.remove(0);
		hull.push(p0);
		//p0를 시작으로 반시계 방향을 이루는 점을 앞오르 오도록 정렬. 세 점이 일직선이면 p0이랑 가까운 것부터 오도록 정렬. 
		points.sort(new LTC(p0));
		//p0 다음 점을 선택
		L p1=points.remove(0);
		hull.push(p1);
		
		//모든 점에 대해서
		for (int i = 0; i < N-2; i++) {
			//다음으로 가까운 점을 선택
			L b=points.get(i);
			while(hull.size()>=2) {// 두개이상 -> 선택한 점이 2개 이상
				L a=hull.pop();   //위의것이 뒤에 들어간것.
				L p=hull.peek();  //먼저 들어간것
				int ccwvalue=ccw(p,a,b);	//세 점을 기준으로 해서 p->a->b 방향이 반시계 방향인지 확인
				if(ccwvalue>0) {	//반시계 방향이면 해당 점은 껍질에 속한 것 -> 스택에 저장.
					hull.push(a);
					break;
				}
			}
			hull.push(b);	//선택한 점을 껍질에 해당하는지 확인하기 위해서 스택에 저장
		}
		System.out.println(hull.size());
/*		int size=hull.size();
		for (int i = 0; i < size; i++) {
			L a=hull.pop();
			System.out.println(a.x+" "+a.y);
		}*/
	}

	//반시계방향 여부 확인
	static int ccw(L p, L a, L b) {
		long result = cross(vec(p,a),vec(a,b));
    	if (result > 0) {   // 외적이 양수 -> 반시계 방향
            return 1;
        } else if (result < 0) {    // 외적이 음수 -> 시계 방향
            return -1;
        } else {	//세 점이 일직선인 경우
            return 0;
        }
	}
	//두 벡터의 외적 값을 반환
	static long cross(L a, L b) {
		return a.x*b.y-a.y*b.x;
	}
	//ab-> ob-oa 상대벡터
	static L vec(L a, L b) {
		long x=b.x-a.x;
		long y=b.y-a.y;
		return new L(x,y);
	}
	
	//두 점 사이의 거리 비교를 위한 값을 반환
	static long dist(L p1, L p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}
