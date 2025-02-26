package day0204;

public class VariableArray {

	public VariableArray() {
		//1.선언
		int[][] arr = null;
		//2.생성)
		arr = new int[5][];
		//3.행마다 열의 생성)
		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[] {1,2,3,4,5};
		arr[3] = new int[] {1};
		arr[4] = new int[] {10,20,30,40};
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d]행에 열의 수 %d개\n",i,arr[i].length);
		}
		//4.값할당)
		arr[0][0] = 10;
		arr[1][1] = 10;
		arr[2][3] = 50;
		//5.값사용)
		for(int[] oneArr : arr) {
			for (int value : oneArr) {
				System.out.printf("%d\t",value);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		new VariableArray();
	}

}
