package chap03_1;

import java.util.Scanner;

//선형 검색의 과정을 자세히 나타냄
public class Quiz2 {
	
	//이 메서드에서는 선형 과정을 나타내는 프로그램을 출력
	static int seqSearchEx(int[] a, int n, int key) { //길이가 n인 배열 a에서 key가 있는지 찾기
		System.out.print("   |");
		for(int i = 0; i < n; i++) {
			System.out.printf("%4d", i); //4칸 안에서 숫자 넣기
		}
		System.out.println();
		
		System.out.print("---+"); //4칸 기준이니까
		for(int i = 0; i < 4 * n + 2; i++) { //-가 4칸*n씩 있고, 2번 더 넣기, 크게 중요x
			System.out.print("-");
		}
		System.out.println();
		
		for(int i = 0; i < n; i++) { //행(가로)
			
			System.out.print("   |"); //맨 위에 하나 넣고
			//String.format() - 문자열의 형식 설정
			//%%%퍼센트, 정수(인덱스*4칸 하고 + 3), 문자열(공백), * 넣고, 다음 줄
			//%%ds를 넣으면 %가 출력되어 나옴, %s
			//""는 d에 들어가고, (i * 4) + 3)는 s에 들어감
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			
			/*************************************************************/
			
			//왼쪽에 인덱스 표시
			System.out.printf("%3d|", i);
			for(int j = 0; j < n; j++) { //열(세로)
				System.out.printf("%4d", a[j]);
			}
			
			/*************************************************************/
			
			System.out.println("\n   |");
			
			if(a[i] == key)
				return i; //검색 성공, return i하면서 break 됨
		}
		
		return -1; //검색 실패
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = scan.nextInt();
		int[] x = new int[num]; //길이가 num인 배열
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]=");
			x[i] = scan.nextInt();
		}
		
		System.out.print("찾는 값: ");
		int ky = scan.nextInt();
		
		int result = seqSearchEx(x, num, ky); //배열 x에서 값이 ky인 요소 검색하는 메서드 seqSearchEx 실행
		
		if(result == -1)
			System.out.println("찾는 값이 없습니다.");
		else
			System.out.println(ky + "는 " + "x[" + result + "]에 있습니다.");
	}
}
