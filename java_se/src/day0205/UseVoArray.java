package day0205;

public class UseVoArray {

	public static void main(String[] args) {

		StudentScoreVO[] ssArr = new StudentScoreVO[5];
		ssArr[0] = new StudentScoreVO(1,"루피",57,59,42,90);
		ssArr[1] = new StudentScoreVO(2,"상디",75,77,79,89);
		ssArr[2] = new StudentScoreVO(3,"쵸파",97,100,98,100);
		ssArr[3] = new StudentScoreVO(4,"조로",87,88,88,84);
		ssArr[4] = new StudentScoreVO(5,"나미",95,91,99,93);
		String[] titleArr = new String[] {"번호","이름","java","oracle","jdbc","html","총점","평균"};
	
		System.out.println("--------------------------------------------------------------");
		System.out.println("\t\t\t시험결과");
		System.out.println("--------------------------------------------------------------");
		System.out.printf("응시인원[%d]명\n",ssArr.length);
		System.out.println("--------------------------------------------------------------");
		for(String title : titleArr) {
			System.out.printf("%s\t",title);
		}
		System.out.println("\n--------------------------------------------------------------");
		
		int javaScore = 0, oracleScore = 0, jdbcScore = 0, htmlScore = 0, total = 0;
		double subjectCnt = 4.0;
		int javaTotal = 0;
		StudentScoreVO topSs = null;
		int topStu = 0;
		for(StudentScoreVO ssVO: ssArr) {
			javaScore = ssVO.getJava();
			oracleScore = ssVO.getOracle();
			jdbcScore = ssVO.getJdbc();
			htmlScore = ssVO.getHtml();
			
			total = javaScore + oracleScore + jdbcScore + htmlScore;
			if(total > topStu) { // 가장 높은 점수를 받은 학생 정보 처리
				topStu =total;
				topSs = ssVO;
			}
			javaTotal += javaScore;
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\n",ssVO.getNum(),ssVO.getName(),javaScore,oracleScore,jdbcScore,htmlScore,total,total/subjectCnt);
			
		}
		System.out.println("자바 총점:" + javaTotal);
		System.out.printf("1등 학생의 이름[%s] 번호[%d]\n",topSs.getName(),topSs.getNum());
		
	}

}
