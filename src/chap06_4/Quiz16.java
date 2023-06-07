package chap06_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Quiz16 {

	static class PhyscData {
		String name;
		int height;
		double vision;
		
		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		@Override
		public String toString() {
			return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
		}
		
		//키 오름차순용 comparator
		
		//HeightOrderComparator 인스턴스를 생성
		static final Comparator<PhyscData> Vision_Order = new VisionOrderComparator();
		
		//compare 메서드를 구현한 클래스 작성
		private static class VisionOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.vision < d2.vision) ? 1 : ((d1.vision > d2.vision) ? -1 : 0);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhyscData[] x = { //키의 오름차순으로 정렬되어 있음
				new PhyscData("이나령", 162, 0.3),
				new PhyscData("유지훈", 168, 0.4),
				new PhyscData("김한결", 169, 0.8),
				new PhyscData("홍준기", 171, 1.5),
				new PhyscData("전서현", 173, 0.7),
				new PhyscData("이호연", 174, 1.2),
				new PhyscData("이수민", 175, 2.0),
		};
		
		//배열 x를 PhyscData의 Height_Order를 사용하여 정렬
		Arrays.sort(x, PhyscData.Vision_Order);
		
		System.out.println("--- 신체검사 리스트 ---");
		System.out.println(" 이름      키  시력");
		System.out.println("-----------------------");
		for(int i = 0; i < x.length; i++) {
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		}
	}
	
}
