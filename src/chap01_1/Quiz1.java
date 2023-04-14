package chap01_1;

public class Quiz1 {

	static int max4(int a, int b, int c, int d) {
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		if(d > max) max = d;
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println("네 값 중 최댓값은 " + max4(1, 2, 3, 4));
	}
}
