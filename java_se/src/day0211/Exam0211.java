//package day0211;
//
//import java.util.Calendar;
/**
 * -원하는 년도와 월을 매개변수로 입력 받아 해당 년,월의 달력을 String으로 반환하는 Method를 작성하세요.
 * Calendar 클래스를 사용하여 해당 년, 월의 달력을 StringBuilder에 넣고 반환합니다.
 * 만약 년,이나 월이 입력되지 않은 경우에는 현재 년과 월로 달력을 생성합니다.
 * 
 *  -위의 method를 호출하여 반환되는 달력을 받아서 콘솔에 출력하는 method를 작성하세요.
 */
//public class Exam0211 {
//	
//	public void getCalendar(String year, String month) {
//		Calendar cal = Calendar.getInstance();
//		if (year == null || year.isEmpty() || month == null || month.isEmpty()) {
//            year = String.valueOf(cal.get(Calendar.YEAR));
//            month = String.valueOf(cal.get(Calendar.MONTH) + 1);
//        }
//		
//		
//		StringBuilder calendar = new StringBuilder();
//		cal.set(year, month-1, 1);
//		
//		int dayInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
//        
//        calendar.append(year).append("년 ").append(month).append("월\n")
//        .append("일\t월\t화\t수\t목\t금\t토\n");
//        
//        for(int i=0; i<firstDay-1; i++) {
//        	calendar.append("\t");
//        }
//        
//        for (int day = 1; day <= dayInMonth; day++) {
//            calendar.append(day).append("\t");
//
//            if ((firstDay+day-1) % 7 == 0) {
//                calendar.append("\n");
//            }
//        }
//        
//        System.out.println(calendar);
//        
//	}
//	
//	public static void main(String[] args) {
//
//		new Exam0211().getCalendar(2025, 4);
//	}
//
//}
