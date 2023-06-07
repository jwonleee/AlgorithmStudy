package chap09_1;

import java.util.Comparator;
import java.util.Scanner;

public class LinkedListTester {

	static Scanner scan = new Scanner(System.in);

	//데이터(회원번호 + 이름)
	static class Data {
		//상수는 항상 대문자
		static final int NO = 1; //번호를 입력 받습니까?
		static final int NAME = 2; //이름을 입력 받습니까?

		private Integer no; //회원번호
		private String name; //이름

		@Override
		public String toString() {
			return "Data [no=" + no + ", name=" + name + "]";
		}

		//데이터를 입력합니다.
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if((sw & NO) == NO) { //?????????숫자를 넣는건 알겠는데 sw & NO는 몰까?
				System.out.print("번호: ");
				no = scan.nextInt();
			}
			if((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = scan.next();
			}
		}

		//회원번호로 순서를 매기는 comparator
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
			}
		}

		//회원이름으로 순서를 매기는 comparator
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	} //end Data class


	//메뉴 열거형
	public enum Menu {
		ADD_FIRST("머리에 노드를 삽입"),
		ADD_LAST("꼬리에 노드를 삽입"),
		RMV_FIRST("머리 노드를 삭제"),
		RMV_LAST("꼬리 노드를 삭제  "),
		RMV_CRNT("선택 노드를 삭제  "),
		CLAER("모든 노드를 삭제 "),
		SEARCH_NO("번호로 검색       "),
		SEARCH_NAME("이름으로 검색     "),
		NEXT("선택 노드로 이동"),
		PRINT_CRNT("선택 노드를 출력  "),
		DUMP("모든 노드를 출력 "),
		TERMINATE("종료");

		private final String message; //출력할 문자열

		//서수가 idx인 열거를 반환
		static Menu MenuAt(int idx) {
			for(Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m;
			return null;
		}

		//생성자
		Menu(String string) {
			message = string;
		}

		//출력할 문자열을 반환
		String getMessage() {
			return message;
		}
	} //end Enum


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
			key = scan.nextInt();		} while (key < Menu.ADD_FIRST.ordinal() ||
				key > Menu.TERMINATE.ordinal() );
		return Menu.MenuAt(key);
	} //end 메뉴 선택

	//main
	public static void main(String[] args) {
		Menu menu; //메뉴
		Data data; //추가용 데이터 참조
		Data ptr; //검색용 데이터 참조
		Data temp = new Data(); //입력용 데이터

		LinkedList<Data> list = new LinkedList<Data>(); //리스트 생성

		do {
			System.out.println();
			switch (menu = SelectMenu()) {
			
			case ADD_FIRST : //머리에 노드 삽입
				data = new Data();
				data.scanData("머리에 삽입", Data.NO | Data.NAME);
				list.addFirst(data);
				break;

			case ADD_LAST : //꼬리에 노드를 삽입
				data = new Data();
				data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
				list.addLast(data);
				break;

			case RMV_FIRST : //머리 노드를 삭제
				list.removeFirst();
				break;

			case RMV_LAST : //꼬리 노드를 삭제
				list.removeLast();
				break;

			case RMV_CRNT : //선택 노드를 삭제
				list.removeCurrentNode();
				break;

			case SEARCH_NO : //회원번호로 검색
				temp.scanData("검색", Data.NO);
				ptr = list.search(temp, Data.NO_ORDER);
				if(ptr == null)
					System.out.println("그 번호의 데이터가 없습니다.");
				else
					System.out.println("검색 성공: " + ptr);
				break;

			case SEARCH_NAME : //이름으로 검색
				temp.scanData("검색", Data.NAME);
				ptr = list.search(temp, Data.NAME_ORDER);
				if(ptr == null)
					System.out.println("그 이름의 데이터가 없습니다.");
				else
					System.out.println("검색 성공: " + ptr);
				break;

			case NEXT : //선택 노드를 뒤쪽으로 이동
				list.next();
				break;

			case PRINT_CRNT : //선택 노드의 데이터를 출력
				list.printCurrentNode();
				break;

			case DUMP : //모든 노드를 리스트 순서로 출력
				list.dump();
				break;

			case CLAER : //모든 노드 삭제
				list.clear();
				break;
				
			}
		} while (menu != Menu.TERMINATE);
	} //end main

}
