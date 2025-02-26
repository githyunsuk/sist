package day0204;

public class UseArray3 {

	public UseArray3() {
		//1.선언
		int[][][] arr3 = null;
		//2.생성
		arr3 = new int[3][5][6];
		System.out.printf("면 %d, 행 %d, 열 %d\n",arr3.length,arr3[0].length,arr3[0][0].length);
		//3.할당
		//4.사용
		for(int i=0; i<arr3.length; i++) {
//			System.out.printf("arr3[%d]면 시작\n",i);
			for(int j=0; j<arr3[i].length; j++) {
//				System.out.printf("arr3[%d][%d]행 시작\n",i,j);
				for(int k=0; k<arr3[i][j].length; k++) {
					if(j==0 || j==arr3[i].length-1 || k==0 || k==arr3[i][j].length-1) {
						arr3[i][j][k] = 1;
					}
					System.out.printf("%d\t",arr3[i][j][k]);
				}
				System.out.println();
//				System.out.printf("arr3[%d][%d]행 끝\n",i,j);
			}
			System.out.println();
//			System.out.printf("arr3[%d]면 끝\n",i);
		}
		
		//삼차원 배열의 기본형 형식의 사용.
		//면구분괄호와, 행 구분 괄호를 사용해야한다.
		int [][][] arr = { {{1,2,3} ,{4,5,6}}, {{7,8,9},{10,11,12}} };
		System.out.printf("%d면 %d행 %d열\n",arr.length,arr[0].length,arr[0][0].length);
		
		for(int[][] twoArr: arr) { //삼차원 배열의 한 면은 이차원 배열로
			for(int[] oneArr: twoArr) { //이차원 배열의 한 행은 일차원 배열로
				for(int temp: oneArr) { //일차원 배열은 단일 형으로
					System.out.printf("%d\t",temp);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		new UseArray3();
	}
}
