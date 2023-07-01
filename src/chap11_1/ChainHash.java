package chap11_1;

//체인법 - 해시
public class ChainHash<K,V> {
	//해시를 구성하는 노드
	class Node<K,V> {
		private K key;
		private V data;
		private Node<K,V> next; //다음 노드에 대한 참조
		
		//생성자
		public Node(K key, V data, Node<K, V> next) {
			super();
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		//키 값 반환
		K getKey() {
			return key;
		}
		
		//데이터 반환
		V getValue() {
			return data;
		}
		
		//키의 해시 값 반환, 키가 가지고 있는 해시코드
		public int hashCode() {
			return key.hashCode();
		}
	}//end Node
	
	private int size; //해시 테이블 크기
	private Node<K,V>[] table; //해시 테이블
	
	//생성자 - 비어있는 해시 테이블 생성
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) { //테이블 생성X
			this.size = 0;
		}
	}
	
	//해시 값을 크기로 나눈 나머지를 구하는 메서드
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//키 값 key를 갖는 요소의 검색(데이터를 반환)
	public V search(K key) {
		int hash = hashValue(key); //검색할 데이터의 해시 값
		Node<K,V> p = table[hash]; //선택 노드
		
		while(p != null) {
			if(p.getKey().equals(key))
				return p.getValue(); //검색 성공
			p = p.next; //다음 노드에 주목
		}
		return null; //검색 실패	
	}
	
	//키 값 key, 데이터 data를 갖는 요소의 추가
	public int add(K key, V data) {
		int hash = hashValue(key); //추가할 데이터의 해시 값
		Node<K,V> p = table[hash]; //선택 노드
		
		while(p != null) {
			if(p.getKey().equals(key)) //이 키 값을 이미 등록됨
				return 1;
			p = p.next; //다음 노드에 주목
		}
		
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		table[hash] = temp;  //노드를 삽입
		return 0;
	}
	
	//키 값 key를 갖는 요소의 삭제
	public int remove(K key) {
		int hash = hashValue(key); //삭제할 데이터의 해시 값
		Node<K,V> p = table[hash]; //선택 노드, 첫번째 노드를 가리킴
		Node<K,V> pp = null; //바로 앞의 선택 노드
		
		while(p != null) { //노드가 존재하고
			if(p.getKey().equals(key)) { //찾으면
				if(pp == null) //삭제하려는 노드가 첫 번째 노드인 경우
					table[hash] = p.next;
				else //삭제하려는 노드가 첫 번째 노드가 아닌 경우
					pp.next = p.next;
				return 0;
			}
			//못 찾으면 다음 노드 확인
			pp = p;
			p = p.next; //다음 노드를 가리킴
		}
		return 1; //키 값이 없음
	}
	
	//해시 테이블을 덤프
	public void dump() {
		for(int i = 0; i < size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d ", i);
			
			while(p != null) {
				System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
	
}
