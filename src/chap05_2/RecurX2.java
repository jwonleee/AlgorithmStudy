package chap05_2;

public class RecurX2 {

	//꼬리 재귀 제거
	static void recur(int n) {
		while(n > 0) {
			recur(n-1);
			System.out.println(n);
			n = n-2;
		}
	}
}
