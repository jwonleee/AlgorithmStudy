package chap03_1;

import java.util.Scanner;

//선형 검색(보초법)
public class Quiz1 {
	//요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색 합니다.
	static int seqSearchSen(int[] a, int n, int key) {
		int i; //while 반복문 시작 = 0
		
		a[n] = key; //보초를 추가, 맨 마지막 인덱스에 검색할 key 추가
		
		/*
		 * while(true) {
		 * 	if(a[i] == key) { //검색 성공 
		 * 		break;
		 * 	}
		 * 	i++;
		 * }
		 */
		
		for(i = 0; a[i] != key; i++) { //0부터 
			;
		}
		return i == n ? -1 : i; //마지막 인덱스 n이면 -1, 중간에 break가 걸리면 i
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = scan.nextInt();
		int[] x = new int[num+1]; //요솟수 num+1로 배열 길이 만듦
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = scan.nextInt(); //배열에 값 입력
		}
		
		System.out.print("검색할 값: "); //키 값을 입력
		int ky = scan.nextInt();
		
		int idx = seqSearchSen(x, num, ky); //배열 x에서 값이 ky인 요소를 검색
		
		if(idx == -1) { //마지막 인덱스 값까지 갔을 때 나타나면 -1이니까 그 전에는 못 찾은 것
			System.out.println("그 값의 요소가 없습니다.");
		} else { //중간에 break 걸리면 i
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
		}
		
	}
	
}
