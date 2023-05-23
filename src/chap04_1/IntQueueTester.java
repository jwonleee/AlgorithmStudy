package chap04_1;

import java.util.Scanner;

import chap04_1.IntQueue.EmptyIntQueueException;
import chap04_1.IntQueue.OverflowIntQueueException;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		IntQueue s = new IntQueue(64); //최대 64를 인큐할 수 있는 큐
		
		while(true) {
			
			System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
			System.out.print("(1)인큐 (2)디큐 (3)피크 " + 
							 "(4)덤프 (0)종료 : ");
			
			int menu = scan.nextInt();
			if(menu == 0) break; //종료시 멈춤
			
			int x; //넣거나 뺄 데이터 변수
			switch (menu) {
			
			//인큐 - 데이터가 꽉 차 있을 수 있음
			case 1: 
				System.out.print("데이터: ");
				x = scan.nextInt();
				try {
					s.enque(x);
				} catch (IntQueue.OverflowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
			
			//디큐 - 데이터가 없을 수 있음
			case 2:
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 없습니다.");
				}
				break;
			
			//피크 - 데이터가 없을 수 있음
			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 없습니다.");
				}
				break;
				
			//덤프
			case 4:
				s.dump();
				break;
			}
			
		}
	}
	
}
