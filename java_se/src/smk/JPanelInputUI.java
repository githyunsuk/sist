package smk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JPanelInputUI extends JPanel {
	
	//밖에서 이벤트리스너에 쓰려면 get해야돼서 인스턴스 변수로 해야돼  
	private JTextField jtfDisplay; // 입력 필드
    private JButton jbtn; // 버튼
	
	public JPanelInputUI() {
		
		//본 클래스는 extends를 JPanel로 했고, JPanel의 기본 레이아웃은 FlowLayout이어서, 패널과 날짜라벨을 나누기 위해서는 
		//	기본 레이아웃을 바꿔줄 필요가 있다. 
		//this.setLayout(new BorderLayout());
		
		JLabel jlabel = new JLabel("Month :");
		
		//JTextField jtfDisplay = new JTextField(10);
		//JButton jbtn = new JButton("확인");
		
		jtfDisplay = new JTextField(10); // 클래스 필드를 초기화
        jbtn = new JButton("확인"); // 클래스 필드를 초기화
		
        //패널을 하나 만들어서, 1줄짜리로 레이아웃 설정하고, 컴포넌트들 추가 
		JPanel jpNorth = new JPanel();
		jpNorth.setBorder(new TitledBorder("타이틀 보더")); //JPanel에 타이틀보더 추가 
		jpNorth.setLayout(new GridLayout(1, 5));
		jpNorth.add(jlabel);
		jpNorth.add(jtfDisplay);
		jpNorth.add(jbtn);
		
		//옵션창 (비즈니스 로직 미완성)
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("KOREA");
		jcb.addItem("US");
		jcb.addItem("JAPAN");
		jcb.addItem("CHINA");
		jpNorth.add(new JLabel("??(미지원):"));
		jpNorth.add(jcb);
		
		//패널과 날짜라벨을 배치
		add(jpNorth);
		//add(dateLabel, "South");
		
	}
	
	//이게 더 편해서 이거쓸래 
	public int getMonth() {
		return Integer.parseInt(jtfDisplay.getText());
	}
	

    // 입력 필드 값 가져오기 위한 getter
    public JTextField getTextField() {
        return jtfDisplay;
    }

    // 버튼 가져오기 위한 getter
    public JButton getButton() {
        return jbtn;
    }
	
	/**
     *  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd [EEEE] [a] hh:mm:ss", Locale.JAPAN);
		String format = ldt.format(dtf);
		
		System.out.println(format);
	 */
	

	
}
