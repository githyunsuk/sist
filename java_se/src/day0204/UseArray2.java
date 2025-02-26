package day0204;

/**
 * 행과 열로 구성된 이차원 배열. 
 */
public class UseArray2 {

	public UseArray2() {
		//1.선언
//		int[][] arr2 = null;
		//2.생성
//		arr2 = new int[3][4];
		//1+2
		int[][] arr2 = new int[3][4];
		
		System.out.printf("행의 수:%d, 열의 수:%d\n",arr2.length,arr2[0].length);
		//3.값 할당
		arr2[0][0] = 2025;
		arr2[0][1] = 2;
		arr2[0][2] = 4;
		arr2[0][3] = 11;
		
		//일괄처리: 인덱스가 2개(행,열) 필요
		for(int i=0; i<arr2.length; i++) {
			System.out.printf("arr2[%d]행 시작\n",i);
			
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("arr2[%d][%d]=%-5d",i,j,arr2[i][j]);
			}
			System.out.println();
		}
		
		int[] tempArr = arr2[0];
		arr2[2] = tempArr;
		for(int v: arr2[2]) {
			System.out.println(v);
		}
		
		System.out.println("----------향상된 for-----------");
		for(int[] arr: arr2) {
			for(int value:arr) {
				System.out.printf("%d\t",value);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		new UseArray2();
	}

}
