package chap03_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz4 {

	static int binSearchEx(int[] a, int n, int key) {
		
		System.out.print("   |");
		for(int i = 0; i < n; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println(); //맨 윗줄 끝
		
		System.out.print("---+");
		for(int i = 0; i < 4*n + 2; i++) {
			System.out.print("-");
		}
		System.out.println(); //두번째 줄 끝
		
		
		int pl = 0; //인덱스 맨 앞
		int pr = n-1; //인덱스 맨 뒤
		
		//pl, pr, pc로 무한반복문을 만들어야 하기 때문에 do ~ while, while 사용
		
		do {
			int pc = (pl + pr) / 2; //인덱스 중앙
			System.out.println("pc는: " + pc); //배열의 길이가 2이면 중앙값은 0임

			//3줄 1세트 만들기
			//첫번째줄
			System.out.print("   |");
			//<-   + 까지 만들기
			if(pl != pc) //맨 앞 인덱스와 중앙 인덱스가 같지 않으면, 3개 이상인 경우
				System.out.printf(String.format("%%%ds<-%%%ds+", (pl*4)+1, (pc-pl)*4), "", "");
			else //pl == pc이면, 2개인 경우
				System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
			//   -> 만들기
			if(pc != pr) //중앙 인덱스와 맨 뒤 인덱스가 같지 않으면
				System.out.printf(String.format("%%%ds->\n", (pr - pc)*4 -2), "");
			else
				System.out.println("->");
			
			//두번째 줄
			System.out.printf("%3d|", pc); //맨 왼쪽에 현재 검색하고 있는 요소의 인덱스 값 표시
			for(int i = 0; i < n; i++) {
				System.out.printf("%4d", a[i]); //인덱스 값 넣기
			}
			
			//세번쨰 줄
			System.out.println("\n   |");
			
			//이진 검색
			if(a[pc] == key) //중앙 인덱스 값이 key이면 key 반환
				return pc;
			else if(a[pc] < key) //중앙 인덱스 값이 key보다 작으면
				pl = pc + 1; //시작 값을 중앙인덱스+1 부터 시작하게 업데이트
			else //중앙 인덱스 값이 key보다 크면
				pr = pc - 1;
		} while (pl <= pr); //맨 앞 인덱스가 맨 뒤 인덱스보다 커지지 않을때까지 계속 반복
		//그 사이에 중앙값이 key값으로 나오면 그 값을 return하고 없으면 -1(검색 실패) return
		return -1; //검색 실패
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("요솟수: ");
		int num = scan.nextInt();
		int[] x = new int[num]; //길이가 num인 배열
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		}
		Arrays.sort(x); //오름차순 정렬
		System.out.println(Arrays.toString(x));
		
		System.out.print("찾는값: ");
		int ky = scan.nextInt();
		
		int result = binSearchEx(x, num, ky);
		
		if(result == -1)
			System.out.println("찾는 값이 없습니다.");
		else
			System.out.println(ky + "는 x[" + result + "]에 있습니다.");
	}
}
