package day0116;

public class Test {
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		int sum = 0;
		
		for(int i=0; i<500; i++) { 
			sum += i; 
			System.out.println("sum:"+sum+", i:"+i);
		}
		 
		
		System.out.println("sum:"+sum);
		long endTime = System.currentTimeMillis();
		
		System.out.println("수행시간:"+(endTime - startTime) + "ms");
	}

}
