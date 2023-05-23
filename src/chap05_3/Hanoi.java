package chap05_3;

import java.util.Scanner;

//하노이의 탑
public class Hanoi {
	
	//no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
	static void move(int no, int x, int y) {
		if(no > 1) //시작 기둥의 값을 중간 기둥으로 옮김
			//맨 아래 원반 제외하고 나머지들은 목적지가 아닌 곳으로 재귀적으로 이동시킴
			move(no - 1, x, 6 - x - y); //기둥 번호의 합이 6이므로 중간 기둥 번호 = 6 - x - y
			
		System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김"); //시작 → 목표 기둥으로 옮김을 출력
		
		if(no > 1) //중간 기둥의 값을 목표 기둥으로 옮김
			//위에서 놨던 원반들을 목표기둥으로 옮김
			move(no - 1 , 6 - x - y, y);
	}
	
	//quiz7 비재귀적으로 수정
	static void move2(int no, int x, int y) {
		while(true) {
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.print("원반의 개수: ");
		int n = scan.nextInt();
		
		move(n, 1, 3); //1번 기둥의 n개의 원반을 3번 기둥으로 옮김
	}
}
