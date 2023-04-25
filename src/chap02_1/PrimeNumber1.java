package chap02_1;

public class PrimeNumber1 {

	//1000이하의 소수를 열거
	public static void main(String[] args) {
		int counter = 0; //나눗셈의 횟수
		
		for(int i = 2; i <= 1000; i++) {
			int j;
			for(j = 2; j < i; j++) {
				counter++; //나눗셈을 할 때마다 count를 증가해 연산 횟수 계산
				if(i % j == 0) { //나누어 떨어지면 소수x
					break;
				}
			}
			if(i == j) { //마지막까지 나누어 떨어지지 않음
				System.out.println(i);
			}
		}
		System.out.println("시행한 횟수: " + counter);
	}
}
