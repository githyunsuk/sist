package smk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalendarMain extends JPanel{ //JPanel로 해야 다른 패널에도 들어갈수있어. JFrame은 다른 layout세팅에 들어갈수가 없어. 

	private JPanelCalendarUI jpcdUI; // 기존 달력 패널을 저장할 변수
    private JPanelInputUI jpIpUI;
    private JTextField jtField; // 월 입력 필드
    
    public CalendarMain() {
    	
		jtField = new JTextField(10);
		JTextArea jArea = new JTextArea();
		JScrollPane jsPane = new JScrollPane(jArea);
		
		this.setLayout(new BorderLayout());
		
		//입력패널 
		jpIpUI = new JPanelInputUI();
		add(jpIpUI, "North");
		
        //초기 달력 표시 (현재 월)
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        jpcdUI = new JPanelCalendarUI(currentMonth);
        jpcdUI.setPreferredSize(new Dimension(500, 400)); //크기조절, 부모컨텐츠 크기에 주의 
        add(jpcdUI, "Center");
		
		
		//확인버튼 클릭 시, 입력된 월을 기준으로 달력 출력 
		jpIpUI.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int month = jpIpUI.getMonth();
					if(month < 1 || month > 12) {
                        JOptionPane.showMessageDialog(null, "1~12 사이의 숫자를 입력하세요.");
                        return;
                        //month = cal.get(Calendar.MONTH + 1); //1~12값이 아니면 이번달로설정 
					}
					
					// 기존달력패널 제거
					remove(jpcdUI);
					
					//입력된 달로 달력 출력, center에 
					jpcdUI = new JPanelCalendarUI(month); // 생성자에 혹은 메서드에..  int 매개변수 대입, 달력생성
			        jpcdUI.setPreferredSize(new Dimension(500, 400)); //크기조절, 메서드에 의해 갱신되면 초기화되므로.. 또 해줘야지  
					add(jpcdUI, "Center");
					
					//UI갱신
                    revalidate();
                    repaint();
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "숫자를 입력하세요.");
				}
				
			}
		});
		
		setVisible(true);
    }
	
	
}
/**
 * setLayout의 종류에따라, add된 컴포넌트들의 배치 위치가 달라짐
 * 
 * setLayout(new BoerderLayout()) : 바깥 테두리 기본레이아웃, 생략가능
 * 	add(컴포넌트객체, South||North||West||East )
 * setLayout(new FolowLayout()) : 컴포넌트가 고유 크기를 가지며 왼쪽->오른쪽 순으로 배치
 * 	add(컴포넌트객체)
 * setLayout(new GridLayout(m,n)) : 행, 열을 가지는 레이아웃. 행,열에 맞춰 정렬된다. 컴포넌트가 고유 크기를 잃고, 모두 일정한 크기를 갖게된다.
 *  add(컴포넌트객체)
 *  
 * JPanel 클래스 상속하여, 여러 컴포넌트를 묶어 객체 생성하고, 그 객체를 레이아웃 할 수도 있음 
 * 
 * 컴포넌트 종류: 
 * 	JLabel
 * 	JButton
 * 	JTextArea (scrollbar 있음)
 * 	JTextField (scrollbar 없음, 한줄짜리 텍스트이니까.. )
 * 	JRadioButton ("", true)
 * 	ButtonGroup
 * 		- buttonGroup.add(JRadioButton객체);
 * 	JScrollPane(JTextArea 객체)
 * 	JPasswordField 
 * 	JComboBox<E>()
 * 		- jComboBox.addItem("");
 * 		
 *  //4. 윈도우의 크기 설정(사용자UI)
 *	setSize(400,400);
 *	//5. 윈도우를 보여주기 위한 설정 
 *	setVisible(true);
 *	//6. 윈도우 종료처리 (x버튼 눌렀을때, 인스턴스 소멸되게)
 *	setDefaultCloseOperation(EXIT_ON_CLOSE);
 *
 */