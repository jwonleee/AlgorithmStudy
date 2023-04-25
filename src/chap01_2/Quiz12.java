package chap01_2;

public class Quiz12 {

	public static void main(String[] args) {
		
		
		 System.out.println("  |  1 2 3 4 5 6 7 8 9");
		 System.out.println("--+------------------------");
		 for(int i = 1; i <= 9; i++) {
			 System.out.print(i+" |");
			 for(int j = 1; j <= 9; j++) {
				 System.out.printf("%3d", i*j);
			 }
			 System.out.println();
		}
		 
		
		System.out.print("  |");
		for(int i=1; i <= 9; i++) {
			System.out.printf("%3d",i); //%3 정수에 대해 세칸의 넓이로 출력하라
		}
		System.out.println("\n-------------------------------");
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%2d|", i);
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i*j);
			}
			System.out.println();
		}
		
	}
	
}
