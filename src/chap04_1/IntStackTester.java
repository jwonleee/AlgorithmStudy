package chap04_1;

import java.util.Scanner;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//IntStack 클래스 만듦
		IntStack s = new IntStack(64); //최대 64를 푸시할 수 있는 스택
		
		while(true) { //무한반복
			System.out.println("현재 데이터 수: " + s.size() + " /"
											   + s.capacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 " + 
							   "(4)덤프 (5)찾기 (6)삭제 " +
							   "(7)정보 (0)종료");
			
			int menu = scan.nextInt();
			if(menu == 0) break; //0 누르면 종료
			
			int x; //scan으로 값 넣을 데이터 변수
			switch (menu) {
			case 1: //푸시
				System.out.print("데이터: ");
				x = scan.nextInt();
				try {
					s.push(x);
				} catch (Exception e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			
			case 2: //팝
				System.out.print("데이터: ");
				x = scan.nextInt();
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (Exception e) {
					System.out.println("스택이 비어있습니다.");
				}
			break;
			
			case 3: //피크
				try {
					x = s.peak();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (Exception e) {
					System.out.println("스택이 비어있습니다.");
				}
			break;
			
			case 4: //덤프, 데이터 다 확인하니까 필요x0
				s.dump();
				break;
			
			case 5: //검색, 찾기 
				System.out.print("찾는 데이터: ");
				x = scan.nextInt();
				int idx = s.indexOf(x); //인덱스 값 반환
				if(idx >= 0) { //idx 값이 있으면
					System.out.println(x + "의 값은 " + (idx+1) + "번째에 있습니다.");
				} else { //idx = -1
					System.out.println("값을 찾을 수 없습니다.");
				}
				break;
				
			case 6: //삭제
				s.clear();
				break;
				
			case 7: //정보
				System.out.println("현재 스택의 용량은 " + s.capacity() + "입니다.");
				System.out.println("현재 스택의 데이터 수는 " + s.size() + "개 입니다.");
				//if 사용
				System.out.print("현재 스택은 ");
				if(s.isEmpty() == false) {
					System.out.println("비어있습니다.");
				} else {
					System.out.println("비어있지 않습니다.");
				}; 
				//3항 연산자 사용, 조건절 ? ture : false
				System.out.println("현재 스택은 " + (s.isFull() ? "가득 차 있습니다." : "가득차 있지 않습니다."));
				break;
			}
		}
	}
}
