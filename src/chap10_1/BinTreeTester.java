package chap10_1;

import java.util.Scanner;

//이진 검색 트리 클래스 BinTree<K, V>의 이용 예
public class BinTreeTester {

	static Scanner scan = new Scanner(System.in);

	//데이터(회원번호 + 이름)
	static class Data {
		static final int NO = 1; //번호를 입력 받습니까?
		static final int NAME = 2; //이름을 입력 받습니까?

		private int no; //회원번호
		private String name; //이름

		//키 값
		Integer keyCode() {
			return no;
		}
		
		//문자열을 반환
		public String toString() {
			return "(" + no + ") " + name;
		}

		//데이터를 입력
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if((sw & NO) == NO) {
				System.out.print("번호: ");
				no = scan.nextInt();
			}
			if((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = scan.next();
			}
		}
	} //end Data class

	//메뉴 열거형
	enum Menu {
		ADD("삽입"),
		REMOVE("삭제"),
		SEARCH("검색"),
		PRINT("표시"),
		TERMINATE("종료");

		private final String message; //출력할 문자열

		static Menu MenuAt(int idx) { //서수가 idx인 열거를 반환
			for(Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { //생성자
			message = string;
		}

		String getMessage() { //출력할 문자열을 반환
			return message;
		}
	} //end enum

	//메뉴 선택
	static Menu SelectMenu() {
		int key;

		do {
			for(Menu m : Menu.values()) {
				System.out.printf("(%d) %9s   ", m.ordinal(), m.message);
				if((m.ordinal() % 3) == 2 &&
						m.ordinal() != Menu.TERMINATE.ordinal()	)
					System.out.println();
			}
			System.out.print("  : ");
			key = scan.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		return Menu.MenuAt(key);
	} //end SelectMenu

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data(); //입력용 데이터
		
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();
		
		do {
			switch (menu = SelectMenu()) {
				case ADD :
					data = new Data();
					data.scanData("삽입", Data.NO | Data.NAME);
					tree.add(data.keyCode(), data);
					break;
					
				case REMOVE :
					temp.scanData("삭제", Data.NO);
					tree.remove(temp.keyCode());
					break;
					
				case SEARCH :
					temp.scanData("검색", Data.NO);
					ptr = tree.search(temp.keyCode());
					if(ptr != null) {
						System.out.println("그 번호의 이름은 " + ptr + "입니다.");
					} else {
						System.out.println("해당 데이터가 없습니다.");
					} break;
					
				case PRINT :
					tree.print();
					break;
			}
		} while (menu != Menu.TERMINATE);
	} //end main
}
