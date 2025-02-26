package day0124;

public class Reference {

	int i, j;
	
	public void swap(Reference r) {
		int temp = r.i;
		r.i = r.j;
		r.j = temp;
		System.out.printf("호출 중 - i = %d, j = %d\n", r.i, r.j);
	}
	
	public static void main(String[] args) {
		
		Reference r = new Reference();
		r.i = 2025; r.j = 1;
		System.out.printf("호출 전 - i = %d, j = %d\n", r.i, r.j);
		r.swap(r);
		System.out.printf("호출 후 - i = %d, j = %d\n", r.i, r.j);

	}
}
