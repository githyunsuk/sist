package day0218;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame {

	public UseJTable() {
		
		super("JTable 사용");
		
		String[][] rowData = {{"1","루피","서울시 강남구 역삼동","고무고무"},
							  {"2","탄지로","서울시 동대문구 동대문동","귀살대"},
							  {"3","이치고","경기도 의왕시","사신"}};
		String[] columnNames = {"번호","이름","주소","비고"};
		
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
	
		JTable jt = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jt);
		
		String[] data = {"4","젠이츠","수원시 영통구","귀살대"};
		dtm.addRow(data);
		dtm.addRow(new String[] {"5","무잔","서울시 중구","도깨비"});
		add("Center", jsp);
		
		setBounds(100,50,600,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UseJTable();
	}

}
