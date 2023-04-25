package chap01_2;

import java.util.Scanner;

public class Digits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num; //2자리의 양수(10~99)를 입력
		
		do { //무조건 한번은 실행 후 조건 확인 - 조건이 맞지 않으면 다시 실행			
			System.out.print("2자리의 정수 입력: "); num = scan.nextInt();
		} while (num < 10 ||  num > 99); //num >= 10 && num <= 99 하면 안되는 이유: 조건이 true이면 do~while 반복
		
		System.out.println("변수 num의 값은 " + num + "가(이) 되었습니다.");
	}
}
