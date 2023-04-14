package chap01_1;

public class Max3m {

	//max 메서드는 int형 매개변수 a, b, c를 받아 최댓값을 구하고 그것을 int형으로 반환하는 메서드
	static int max(int a, int b, int c) { //세 값을 실인수로 주어 호출
		int max = a; //최댓값 max
		if(b > max) max = b;
		if(c > max) max = c;
		
		return max; //구한 최댓값을 호출한 곳으로 반환
	}
	
	public static void main(String[] args) {
		System.out.println("max(3, 2, 1) = " + max(3, 2, 1));
		System.out.println("max(3, 2, 2) = " + max(3, 2, 2));
		System.out.println("max(3, 3, 2) = " + max(3, 3, 2));
		System.out.println("max(2, 3, 3) = " + max(2, 3, 3));
		System.out.println("max(1, 2, 3) = " + max(1, 2, 3));
	}
}
