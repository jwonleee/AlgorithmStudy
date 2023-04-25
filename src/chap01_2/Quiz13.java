package chap01_2;

public class Quiz13 {

	public static void main(String[] args) {
		
		System.out.print("  |");
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%3d", i); //자리수 맞추기
		}
		System.out.println("\n--+---------------------------");
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%2d|", i);
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i+j);
			}
			System.out.println();
		}
		
	}
}
