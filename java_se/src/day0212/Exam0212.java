package day0212;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam0212 {

	public List<Integer> getDateList(int paramYear, int paramMonth, int paramDay) {
	
		List<Integer> lst = new ArrayList<Integer>();
		
		LocalDate date = LocalDate.of(paramYear, paramMonth, paramDay);
		 int lastDayOfMonth = date.lengthOfMonth();
		 
		 for(int i=1; i<=lastDayOfMonth; i++) {
			 lst.add(i);
		 }
		 
		 return lst;
	}
	
	public void printList(List<Integer> lst) {
		
		System.out.println(lst);
	}
	public static void main(String[] args) {
	
		Exam0212 ex = new Exam0212();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("일 월 날짜를 입력해");
		
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		ex.printList(ex.getDateList(year, month, day));
	}

}
