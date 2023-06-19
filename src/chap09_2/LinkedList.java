package chap09_2;

import java.util.Comparator;

public class LinkedList<E> {
	//노드
	class Node<E> {
		private E data; //데이터
		private Node<E> next; //뒤쪽 포인터(다음 노드 참조)

		//생성자
		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; //머리 노드
	private Node<E> crnt; //선택 노드
	
	
	//생성자
	public LinkedList() {
		super();
		head = crnt = null; //crnt = null로 어떤 요소도 선택하지 않도록 함
	}
	
	//검색
	public E search(E obj, Comparator<? super E> c) { //E타입과 그 조상들만 가능, 하한 제한
		Node<E> ptr = head; //현재 스캔 중인 노드
		
		while(ptr != null) { //마지막 노드 직전까지
			if(c.compare(obj, ptr.data) == 0) { //검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; //다음 노드 선택
		}
		return null;
	}
	
	//서로 같은 노드를 찾아, 가장 앞쪽 노드를 남기고 모두 제거가 아니고 여기서는 모든 노드를 삭제해버림
	public void purge(Comparator<? super E> c) { //비교할 값 = no 또는 name
		Node<E> ptr = head;
		
		while(ptr != null) { //마지막 노드 직전까지 반복
			int count = 0; 
			Node<E> ptr2 = ptr; //비교할 ptr값인데 현재 노드로 초기화
			Node<E> pre = ptr; //현재 노드의 앞쪽 노드
			
			while(pre.next != null) { //현재 노드값(crnt, ptr)이 null이 아닐때까지 반복, 마지막까지
				ptr2 = pre.next; //ptr하고, pre.next는 같은 값인데 변수명을 다르게
				if(c.compare(ptr.data, ptr2.data) == 0) {
					pre.next = ptr2.next;
					count++; //지웠다고, 카운트 셈
				} else { pre = ptr2; }
			}
			
			//여기 뭘까..
			if(count == 0) { //같은 노드가 없으면
				ptr = ptr.next;
			} else { //같은 노드가 있었으면
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
			
		}
		crnt = head;
	}
	
	//머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; //삽입 전의 머리 노드(업데이트 하기 위해서)
		head = crnt = new Node<E>(obj, ptr);
		//삽입할 노드 생성 후
		//생성한 노드를 참조하도록 head를 업데이트 함, 뒤쪽 포인터가 가리키는 곳은 ptr
		//crnt도 새로 만든 노드를 가리키도록 업데이트
	}
	
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		if(head == null) { //리스트가 비어있으면
			addFirst(obj); //머리에 삽입
		} else {
			Node<E> ptr = head; //꼬리 노드를 찾기 위해 머리노드를 가리키도록 초기화한 ptr을
			while(ptr.next != null) //뒤쪽 포인터 값이 null이 아니면 (=마지막 노드가 아님)
				ptr = ptr.next; //다음 노드를 가리키도록 업데이트
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	//머리 노드 삭제
	public void removeFirst() {
		if(head != null) //리스트가 비어있지 않으면
		head = crnt = head.next;
	}
	
	//꼬리 노드 삭제
	public void removeLast() {
		if(head != null) { //리스트가 비어있지 않으면
			if(head.next == null) //노드가 하나만 있으면
				removeFirst(); //머리 노드 삭제
			else {
				//꼬리 노드, 꼬리 노드로부터 두번째 노드를 찾아야 함
				Node<E> ptr = head; //현재 스캔 중인 노드
				Node<E> pre = head; //현재 스캔 중인 노드의 앞쪽 노드
				
				while(ptr.next != null) { //ptr이 마지막 노드가 아니면 다음 노드를 가리키도록 업데이트
					pre = ptr;
					ptr = ptr.next;
				} //while 종료시 ptr은 꼬리 노드, pre는 꼬리로부터 두번째 노드
				pre.next = null; //pre는 삭제 후의 꼬리 노드
				crnt = pre; //crnt는 삭제 후의 꼬리노드 pre
			}
		}
	}
	
	//p 노드 삭제
	public void remove(Node p) {
		if(head != null) { //리스트가 비어있지 않으면
			if(p == head) { //p가 머리 노드이면
				removeFirst(); //머리 노드 삭제
			} else {
				//p의 앞쪽 노드 찾기
				Node<E> ptr = head; //현재 스캔 중인 노드
				while(ptr.next != p) { //ptr의 뒤쪽 포인터가 p와 같을 때까지 반복
					ptr = ptr.next;
					if(ptr == null) return; //p가 리스트에 없으면 메서드 종료
				}
				ptr.next = p.next; //기존의 p다음 노드를 ptr의 다음 노드로 만들어주고, 참조되지 않은 노드의 메모리는 자동으로 해제
				crnt = ptr; //현재 노드를 삭제한 노드의 앞 노드로 업데이트
			}
		}
	}
	
	//선택 노드 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드 삭제
	public void clear() {
		while(head != null) { //노드에 아무것도 없을 때까지
			removeFirst(); //머리 노드 삭제
		crnt = null; //리스트가 비어있으므로 crnt도 null로 업데이트
		}
	}
	
	//선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(crnt == null || crnt.next == null) { //리스트가 비어있거나 선택 노드의 뒤쪽 노트가 없으면
			return false; //이동할 수 없음
		}
		crnt = crnt.next;
		return true;
	}
	
	//선택 노드를 표시
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	//모든 노드를 표시
	public void dump() {
		Node<E> ptr = head;
		
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
		//crnt 값을 업데이트 하지 않음, crnt는 메서드 실행 전 그대로임
	}
	
	//머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retireve(int n) {
		Node<E> ptr = head;
		
		while(n >= 0 && ptr != null) { //n은 양수, 노드에 값이 있음
			if(n-- == 0) { //n번 반복(종료 조건은 n이 0이 될떄까지)
				crnt = ptr; //현재 값이 ptr이 된 곳에서
				return ptr.data; //data 리턴
			}
			ptr = ptr.next; //계속 넘기다가
		}
		
		return null;
	}
}
