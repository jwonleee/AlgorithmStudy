package chap09_4;

import java.util.Comparator;
import java.util.Scanner;

//원형 이중 연결 리스트 클래스 DblLinkedList<E> 사용 예
public class DblLinkedListTester {
	static Scanner scan = new Scanner(System.in);

	//데이터(회원번호 + 이름)
	static class Data {
		static final int NO = 1; //번호를 입력 받습니까?
		static final int NAME = 2; //이름을 입력 받습니까?

		private int no; //회원번호
		private String name; //dlfma

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

		//회원번호로 순서를 매기는 comparator
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.no > o2.no ? 1 : (o1.no < o2.no) ? -1 : 0;
			}
		}

		//이름으로 순서를 매기는 comparator
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.name.compareTo(o2.name);
			}
		}


		//메뉴 열거형
		enum Menu {
			ADD_FIRST("머리에 노드를 삽입"),
			ADD_LAST("꼬리에 노드를 삽입"),
			ADD("선택 노드의 바로 뒤에 삽입"),
			RMV_FIRST("머리 노드를 삭제"),
			RMV_LAST("꼬리 노드를 삭제  "),
			RMV_CRNT("선택 노드를 삭제  "),
			CLAER("모든 노드를 삭제 "),
			SEARCH_NO("번호로 검색       "),
			SEARCH_NAME("이름으로 검색     "),
			NEXT("선택 노드를 뒤쪽으로"),
			PREV("선택 노드를 앞쪽으로"),
			PRINT_CRNT("선택 노드를 출력  "),
			DUMP("모든 노드를 출력 "),
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
			} while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
			return Menu.MenuAt(key);
		} //end SelectMenu


		public static void main(String[] args) {
			Menu menu;
			Data data;
			Data ptr;
			Data temp = new Data(); //입력용 데이터

			DblLinkedList<Data> list = new DblLinkedList<Data>(); //리스트 생성

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

	} //end Data
} //end DblLinkedListTester
