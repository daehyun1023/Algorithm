import java.util.*;
import java.io.*;

public class swea9760PokerGame {

	static char suit, rank;
	static int[] suitInfo;
	static int[] rankInfo;
	static String result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// suit에 대한 정보와 rank에 대한 정보 배열 생성
			suitInfo = new int[4];
			rankInfo = new int[13];
			result = "";
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				String str = st.nextToken();
				suit = str.charAt(0);
				rank = str.charAt(1);
				// 정보 입력
				if (suit == 'S') {
					suitInfo[0]++;
				} else if (suit == 'D') {
					suitInfo[1]++;
				} else if (suit == 'H') {
					suitInfo[2]++;
				} else if (suit == 'C') {
					suitInfo[3]++;
				}

				if (rank == 'A') {
					rankInfo[0]++;
				} else if (rank == 'J') {
					rankInfo[10]++;
				} else if (rank == 'Q') {
					rankInfo[11]++;
				} else if (rank == 'K') {
					rankInfo[12]++;
				} else if (rank == 'T') {
					rankInfo[9]++;
				}
				else {
					rankInfo[rank - 1 - '0']++;
				}
			}
			// 같은 rank가 최대 몇개있는지 확인
			int equalRankCnt = countEqualRank();
			//flush 이면서 straight인 경우
			if (isFlush() && isStraight()) {
				result = "Straight Flush";
			} else if (isFlush()) { // flush인 경우
				result = "Flush";
			} else if (isStraight()) { // straight인 경우
				result = "Straight";
			} else if (equalRankCnt == 4) { // 같은 rank가 4개인 경우
				result = "Four of a Kind";
			} else if (equalRankCnt == 3) { // 같은 rank가 3개인 경우
				if (isFullHouse()) {	// 나머지 2개도 같은 rank이면 full house
					result = "Full House";
				} else {	// 그렇지 않으면 three of a kind
					result = "Three of a kind";
				}

			} else if (equalRankCnt == 2) { // 같은 rank 가 2개인 경우
				if (isTwoPair()) {	// 같은 rank가 2개인 경우가 2번 나오는 경우 two pair
					result = "Two pair";
				} else {	// 그렇지 않으면 one pair
					result = "One pair";
				}
			} else { // 모두 아닌 경우
				result = "High card";
			}

			System.out.println("#" + t + " " + result);
		}
	}

	private static boolean isFullHouse() {
		for (int i = 0; i < 13; i++) {
			if (rankInfo[i] == 2) {
				return true;
			}
		}
		return false;
	}

	private static boolean isTwoPair() {
		int cnt = 0;
		for (int i = 0; i < 13; i++) {
			if (rankInfo[i] == 2) {
				if(++cnt == 2) return true;
			}
		}
		return false;
	}

	private static int countEqualRank() {
		int max = 0;
		for (int i = 0; i < 13; i++) {
			if (max < rankInfo[i]) {
				max = rankInfo[i];
			}
		}
		return max;
	}

	private static boolean isFlush() {
		for (int i = 0; i < 4; i++) {
			if (suitInfo[i] == 5) {
				return true;
			}
		}
		return false;
	}

	private static boolean isStraight() {
		int cnt = 0;
		for (int i = 0; i < 13; i++) {
			if (rankInfo[i] == 1) {
				if(++cnt == 5) return true; 
			} else {
				cnt = 0;
			}
		}
		return false;
	}

}
