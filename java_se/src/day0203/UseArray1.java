package day0203;

/**
 * 일차원 배열: 열로만 구성된 배열
 */
public class UseArray1 {

	public UseArray1() {
		//1.선언
		int[] arr = null;
		//2.생성
		arr = new int[5];
		System.out.println(arr + "," + arr.length);
		//3.값 할당
		arr[0] = 2025;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 16;
		arr[4] = 46;
		//4.값 사용
		System.out.printf("순서대로 %d %d %d %d %d\n",arr[0],arr[1],arr[2],arr[3],arr[4]);
		
		//일괄처리
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			sum += arr[i];
		}
		double avg = (double)sum / arr.length;
		System.out.printf("%.2f\n",avg);
	}
	
	public void usePrimitiveType() {
		System.out.println("------------------------");
		//배열에 할당 될 값을 알고 있을 때
		int[] score = {75,62,99,83};
		System.out.println("배열 크기 " + score.length);
		
		System.out.println("자바\t오라클\tjdbc\tHTML\t총점\t평균");
		int sum = 0;
		for(int i=0; i<score.length; i++) {
			System.out.printf("%d\t",score[i]);
			sum += score[i];
		}
		System.out.printf("%d\t%.2f\t\n",sum,(double)sum / score.length);
		
		for(int i=score.length-1; i>=0; i--) {
			System.out.printf("%d\t",score[i]);
		}
		
		System.out.println("\n----------향상된 for문--------------");
		System.out.println("자바\t오라클\tjdbc\tHTML\t총점\t평균");
		for(int s : score) {
			System.out.printf("%d\t",s);
		}
		System.out.printf("%d\t%.2f\t\n",sum,(double)sum / score.length);
		
		//점수 중: 최고 점수
		int mx_value = 0;
		for(int v:score) {
			if (v > mx_value) {
				mx_value = v;
			}
		}
		System.out.println("최고 점수는 " + mx_value);
		
		//---------------정렬---------------
		for(int i=0; i<score.length-1; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(score[i] > score[j]) {
					int temp = score[j];
					score[j] = score[i];
					score[i] = temp;
				}
			}
		}
		for(int s : score) {
			System.out.printf("%d\t",s);
		}
		
	}
	
	public static void main(String[] args) {

		UseArray1 ua = new UseArray1();
		ua.usePrimitiveType();
		
		//객체 생성 후 method를 하나만 호출하는 경우
		//new 생성자().method명():
		new UseArray1().usePrimitiveType();
	}

}
