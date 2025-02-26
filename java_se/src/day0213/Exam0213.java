package day0213;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Exam0213 {
	
	List<ScoreVO> scoreList;
	
	public Exam0213() {
		scoreList = new ArrayList<ScoreVO>();
	}
	
	public void inputMenu() {
		
		StringBuilder inputMsg = new StringBuilder();
		inputMsg.append("\"이름,자바점수,오라클점수\"를 입력해주세요.\n")
		.append("\"출력\"을 입력하면 현재까지 입력된 값이 console에 출력됩니다.\n")
		.append("\"종료\"를 입력하면 프로그램이 종료가 됩니다.");
		
		while(true) {
			String msg = JOptionPane.showInputDialog(inputMsg);
			if(msg.equals("종료")) {
				exitProg();
			}else if(msg.equals("출력")) {
				printData();
			}else {
				String parts[] = msg.split(",");
				if(parts.length != 3) {
					System.out.println("데이터 형식이 맞지 않습니다.");
				}else {
					addScoreData(parts);
				}
			}
			
		}
	}
	
	public void addScoreData(String[] parts) {
		String name = parts[0];
		int java = Integer.parseInt(parts[1]);
		int oracle = Integer.parseInt(parts[2]);
		
		ScoreVO sc = new ScoreVO(name, java, oracle);
		scoreList.add(sc);
	}
	
	public void printData() {
		if(scoreList.size() == 0) {
			System.out.println("데이터가 존재하지 않습니다.");
		}else {
			System.out.println("번호\t이름\t자바\t오라클\t총점\t평균");
			int idx = 1;
			int javaScore = 0;
			int oracleScore = 0;
			int totalScore = 0;
			double averageScore = 0;
			for(ScoreVO s : scoreList) {
				javaScore = s.getJava();
				oracleScore = s.getOracle();
			    totalScore = javaScore + oracleScore;
			    averageScore = totalScore / 2.0;

			    System.out.printf("%d\t%s\t%d\t%d\t%d\t%.2f\n", idx, s.getName(), javaScore, oracleScore, totalScore, averageScore);

			    idx++;
				
			}
		}
		
	}
	
	public void exitProg() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}


}
