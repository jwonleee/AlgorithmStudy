package chap01_1;

public class Quiz2 {
	
	static int min3(int a, int b, int c) {
		int min = a;
		if(b < min) min = b;
		if(c < min) min = c;
		
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println("세 값 중 최솟값은 " + min3(10, 167, 99));
	}
}
