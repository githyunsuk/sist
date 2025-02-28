package smk;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Board_JTable extends JPanel {
	
	public Board_JTable() {
		
		String[] columnNames = {"번호", "제목", "작성자", "작성일", "조회수"};
		String[][] board= {{"1","아침","민기","2025.02.18","12"}
		,{"2","점심","라파엘","2025.02.19","15"}
		,{"3","저녁","아서","2025.02.20","10"}
		};
		
		//1.Model생성. M
		DefaultTableModel dtm = new DefaultTableModel(board, columnNames);
		
		//2.View 생성 
		JTable jt = new JTable(dtm); //스크롤바가 없어 -> 컬럼명 안보여 
		JScrollPane jsp = new JScrollPane(jt); //스크롤바 넣었어 -> 컬럼 이제 보여 
		
		//3.Model에 데이터 추가
		String[] data = {"4","개발자","신민기","2025.02.21","100"};
		dtm.addRow(data);
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		dtm.addRow(new String[] {"5","위대한사람","신민기","2025.02.22","1000"});
		
		//레이아웃
		/**
		 * FlowLayout 특징 
		 * 컴포넌트의 크기를 자동으로 조정하지 않고, 기본 크기에 맞춰 배치하는 특징
		 * 내용 크기만큼만 공간을 확보하고, 패널 전체를 채우지 않습니다
		 * ➡ 이로 인해, JTable의 크기가 부모 패널보다 작아져 스크롤바가 필요 없다고 판단되어 표시되지 않은 것입니다.
		 */
		JPanel jtablePanel = new JPanel(); //FlowLayout
		jtablePanel.setLayout(new BorderLayout());
		jtablePanel.add(jsp, "Center");
		
//----------------- JList 테스트 -----------------------
		
		//1. Model 생성
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		//2.모델과 has a 관계로 View생성
		JList<String> jl = new JList<String>(dlm); //스크롤바 없어
		JScrollPane jsp2 = new JScrollPane(jl);
		
		dlm.addElement("민기");
		dlm.addElement("라파엘");
		dlm.addElement("아서");
		dlm.addElement("신민기");
		dlm.addElement("민기");
		dlm.addElement("라파엘");
		dlm.addElement("아서");
		dlm.addElement("신민기");
		dlm.addElement("민기");
		dlm.addElement("라파엘");
		dlm.addElement("아서");
		dlm.addElement("신민기");
		
		JLabel titleLabel = new JLabel("작성자");
		
		//레이아웃
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add("North", titleLabel);
		listPanel.add("Center", jsp2);
		
		
		/**
		 *	JTable의 공간이 과도하게 잡혀서, JList가 짤리는 현상이 발생 
		 */
		//위 두개의 패널을 JFrame에 추가
		//this.setLayout(new GridLayout(2, 1));
		//add(jtablePanel);
		//add(listPanel);
		
		/**
		 * 	JSplitPane을 써보자
		 */
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jtablePanel, listPanel );
		jSplitPane.setResizeWeight(0.7);
		jSplitPane.setOneTouchExpandable(true);
		this.setLayout(new BorderLayout());
		add(jSplitPane, "Center");
		
		
	}
	
	
	
	
}
