package day0204;

public class ScoreProcess {

	private String[] nameArr;
	private String[] titleArr;
	private int[][] scoreArr;
	
	
	public ScoreProcess() {
		nameArr = new String[] {"루피","상디","쵸파","조로","나미"};
		titleArr = new String[] {"번호","이름","java","oracle","jdbc","html","총점","평균"};

		scoreArr = new int[][] {{57,59,42,90},
								{75,77,79,89},
								{97,100,98,100},
								{87,88,88,84},
								{95,91,99,93}};
	}
	
	public String[] getNameArr() {
		return nameArr;
	}
	public String[] getTitleArr() {
		return titleArr; 
	}
	public int[][] getScoreArr() {
		return scoreArr;
	}
	
	public void printScore() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("\t\t\t시험결과");
		System.out.println("-----------------------------------------------------------");
		System.out.printf("응시인원[%d]명\n",nameArr.length);
		System.out.println("-----------------------------------------------------------");
		for(String title : titleArr) {
			System.out.printf("%s\t",title);
		}
		System.out.println("\n-----------------------------------------------------------");
		
		int firstNum = 0;
		double avg = 0;
		String first = "";
		
		for(int i=0; i<scoreArr.length; i++) {
			System.out.printf("%d\t%s\t",i+1,nameArr[i]);
			int sum = 0;
			
			for(int j=0; j<scoreArr[i].length; j++) {
				System.out.printf("%d\t",scoreArr[i][j]);
				sum += scoreArr[i][j];
			}
			
			if ((double)sum/4 > avg) {
				avg = (double)sum/4;
				first = nameArr[i];
				firstNum = i;
			}
			
			System.out.printf("%d\t%.2f\t",sum,(double)sum/4);
			System.out.println();
		}	

		System.out.println("-----------------------------------------------------------");
		
		int[] totalScoreArr = new int[5];
		
		for(int i=0; i<scoreArr.length; i++) {
			for(int j=0; j<scoreArr[i].length; j++) {
				totalScoreArr[i] += scoreArr[i][j];
			}
		}
		
		System.out.print("과목 총점         ");
		for(int i=0; i<totalScoreArr.length; i++) {
			System.out.printf("%d\t",totalScoreArr[i]);
		}
		System.out.print("\n과목 평균         ");
		for(int i=0; i<totalScoreArr.length; i++) {
			System.out.printf("%.2f\t",(double)totalScoreArr[i]/scoreArr.length);
		}
		
		System.out.printf("\n1등 학생의 이름[%s] 번호[%d]\n",first,firstNum+1);
		for(int i=0; i<scoreArr[firstNum].length-1; i++ ) {
			for(int j=i+1; j<scoreArr[firstNum].length; j++) {
				if(scoreArr[firstNum][i] > scoreArr[firstNum][j]) {
					int temp = scoreArr[firstNum][j];
					scoreArr[firstNum][j] = scoreArr[firstNum][i];
					scoreArr[firstNum][i] = temp;
				}
			}
		}
		System.out.print("1등 학생의 점수의 오름차순 ");
		for(int i=0; i<scoreArr[firstNum].length; i++) {
			System.out.printf("%d\t",scoreArr[firstNum][i]);
		}
	}
	public static void main(String[] args) {
		new ScoreProcess().printScore();
	}

}
