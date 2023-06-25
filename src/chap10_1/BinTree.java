package chap10_1;

import java.util.Comparator;

//이진 검색 트리
public class BinTree<K, V> {
		
	//노드
	static class Node<K, V> {
		private K key;
		private V data;
		private Node<K, V> left; //왼쪽 자식 노드
		private Node<K, V> right; //오른쪽 자식 노드
		
		//생성자
		public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			super();
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		//키 값을 반환
		K getKey() {
			return key;
		}
		
		//데이터를 반환
		V getValue() {
			return data;
		}
		
		//데이터를 출력
		void print() {
			System.out.println(data);
		}
	} //end Node class
	
	private Node<K, V> root; //루트
	private Comparator<? super K> comparator = null; //비교자
	
	//생성자
	//노드 키 값의 대소 관계를 자연 순서에 따라 수행
	//비교자를 설정하지 않으므로 필드 comparator의 값 = null
	public BinTree() { //루트를 null로 설정하여 노드가 하나도 없는 이진 검색 트리 생성
		root = null;
	}
	
	//생성자
	//노드 키 값의 대소 관계를 판단할 때 비교자를 전달받아서 수행
	public BinTree(Comparator<? super K> c) {
		this(); //인수를 전달받지 않으면 위의 생성자 실행
		comparator = c;
	}
	
	//두 키 값을 비교하는 comp 메서드
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) //key1을 Comparable<K>로 형변환, compareTo로 key2와 비교
				: comparator.compare(key1, key2);
	}
	
	//키에 의한 검색
	public V search(K key) {
		Node<K, V> p = root; //루트에 주목
		
		while(true) {
			if(p == null) //더이상 진행하지 않으면
				return null; //검색 실패
			
			int cond = comp(key, p.getKey()); //key와 노드 p의 키를 비교
			if(cond == 0)
				return p.getValue(); //검색 성공
			else if (cond < 0) //key쪽이 작으면
				p = p.left; //왼쪽 서브트리에서 검색
			else //key 쪽이 크면
				p = p.right; //오른쪽 서브트리에서 검색
		}
	}
	
	//node를 루트로 하는 서브 트리에 노드<K, V>를 삽입
	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey()); //key와 노드 p를 비교
		if(cond == 0)
			return; //삽입 실패, 이미 있음
		else if(cond < 0) { //key값이 삽입할 값보다 작음
			if(node.left == null)
				node.left = new Node<K, V>(key, data, null, null);
			else
				addNode(node.left, key, data); //왼쪽 서브 트리에 주목
		} else { //key값이 삽입할 값보다 큼
			if(node.right == null)
				node.right = new Node<K, V>(key, data, null, null);
			else
				addNode(node.right, key, data); //오른쪽 서브 트리에 주목
		}
	}
	
	//노드를 삽입
	public void add(K key, V data) {
		if(root == null) //트리가 비어있는 상태
			root = new Node<K, V>(key, data, null, null);
		else //addNode 메서드를 호출하여 노드를 삽입
			addNode(root, key, data);
	}
	
	//키 값이 key인 노드를 삭제
	public boolean remove(K key) {
		Node<K, V> p = root; //스캔 중인 노드 (맨 처음은 루트)
		Node<K, V> parent = null; //스캔 중인 노드의 부모 노드
		boolean isLeftChild = true; //p는 부모 노드의 왼쪽 자식인가?
		
		//key의 위치 찾기
		while(true) {
			if(p == null)  //키 값 없음 or 비어있음
				return false; //진행 안 함
			
			int cond = comp(key, p.getKey()); //key와 노드 p의 키 값을 비교
			if(cond == 0) //같으면 검색 성공
				break;
			else {
				parent = p; //가지로 내려가기 전 부모를 설정 (맨 처음은 루트를 부모로 설정)
				if(cond < 0) { //key값이 노드 p보다 작으면
					isLeftChild = true; //왼쪽 자식으로 내려감
					p = p.left; //왼쪽 서브 트리에서 검색
				} else {
					isLeftChild = false;
					p = p.right; //오른쪽 서브트리에서 검색
				}
			} //end else
		} //end while
		//여기까지 마치면 key의 위치를 찾음
		//p == key, parent == p의 부모 노드
		
		
		//1. 단말 노드인 경우, 자식 노드가 하나인 경우
		if(p.left == null) { //p에는 왼쪽 자식이 없음
			if(p == root)
				root = p.right;
			else if(isLeftChild)
				parent.left = p.right; //부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
				//기존에 p.right 포인터를 parent.left에 연결
			else
				parent.right = p.right; //부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
				//기존에 p.right 포인터를 parent.right에 연결
			
		} else if(p.right == null) { //p에는 오른쪽 자식이 없음
			if(p == root)
				root = p.left;
			else if(isLeftChild)
				parent.left = p.left; //부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
			else 
				parent.right = p.left; //부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
		} //end if
		
		//2. 자식 노드가 두 개인 경우
		else {
			parent = p;
			Node<K, V> left = p.left; //서브 트리 가운데 가장 큰 노드
			isLeftChild = true;
			while(left.right != null) { //가장 큰 노드 left를 검색
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			
			p.key = left.key; //left의 키 값을 p로 옮김
			p.data = left.data; //left의 데이터를 p로 옮김
			if(isLeftChild)
				parent.left = left.left; //left 삭제
			else
				parent.right = left.left; //left 삭제
		} //end else
		
		return true;
	} //end remove

	//node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
	private void printSubTree(Node node) {
		if(node != null) {
			printSubTree(node.left);
			System.out.println(node.key + " " + node.data);
			printSubTree(node.right);
		}
	}
	
	//모든 노드를 키 값의 오름차순으로 출력
	public void print() {
		printSubTree(root);
	}
	
	//node를 루트로 하는 서브 트리의 노드를 키 값의 내림차순으로 출력
	private void printSubTreeReverse(Node node) {
		if(node != null) {
			printSubTreeReverse(node.right); //오른쪽 서브트리를 키값의 오름차순으로
			System.err.println(node.key + " " + node.data);
			printSubTreeReverse(node.left); //왼쪽 서브트리를 키값의 오름차순으로
		}
	}
	
	//모든 노드를 키 값의 내림차순으로 출력
	public void printReverse() {
		printSubTreeReverse(root);
	}
	
	
	//최소 key값을 갖는 노드 반환
	private Node<K, V> getMinNode() {
		if(root == null)
			return null;
		else {
			Node<K, V> p = root; //뿌리에 주목
			while(p.left != null) //p의 왼쪽에 값이 없으면 p가 가장 작은 것
				p = p.left;
			return p;
		}
	}
	
	//최대 key값을 갖는 노드 반환
	private Node<K, V> getMaxNode() {
		if(root == null)
			return null;
		else {
			Node<K, V> p = root; //뿌리에 주목
			while(p.right != null) //p의 오른쪽에 값이 없으면 p가 가장 큰 것
				p = p.right;
			return p;
		}
	}
	
	
	//가장 작은 키 값 반환
	public K getMinKey() {
		Node<K, V> minNode = getMinNode();
		return minNode == null ? null : minNode.getKey();
	}
	
	//가장 작은 키 값을 갖는 노드의 데이터를 반환
	public V getDataWithMinKey() {
		Node<K, V> minNode = getMinNode();
		return minNode == null ? null : minNode.getValue();
	}
	
	
	//가장 큰 키 값을 반환
	public K getMaxKey() {
		Node<K, V> maxNode = getMaxNode();
		return maxNode == null ? null : maxNode.getKey();
	}
	
	//가장 큰 키 값을 갖는 노드의 데이터를 반환
	public V getDataWithMaxKey() {
		Node<K, V> maxNode = getMaxNode();
		return maxNode == null ? null : maxNode.getValue();
	}
	
}
