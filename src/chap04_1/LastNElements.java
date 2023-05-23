package chap04_1;

import java.util.Scanner;

public class LastNElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int N = 10; //크기 10으로 고정
		int[] a = new int[N]; //입력 받은 값을 저장
		int cnt = 0; //입력 받은 개수
		int retry; //다시?
		
		System.out.println("정수를 입력하세요");
		
		do {
			System.out.printf("%d번째 정수: ", cnt + 1);
			a[cnt++ % N] = scan.nextInt(); //cnt를 넣고, ++
			
			System.out.print("계속 할까요? (1: 예, 0: 아니오) : ");
			retry = scan.nextInt();
		} while (retry == 1);
		
		int i = cnt - N; //1. 넣은 정수가 N보다 많으면 i의 시작값이 바뀜
		if(i < 0) i = 0; //2. 넣은 정수의 개수가 N보다 작으면 i=0부터 돌면 됨
		
		for( ; i < cnt; i++) { //i의 초기값은 위에서 선언
			System.out.printf("%2d번째의 정수=%d\n", i+1, a[i%N]);
		}
		
	}
	
}
