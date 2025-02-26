package day0220;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Exam0220 extends JFrame {

	private JLabel nameLabel, ageLabel, genderLabel, numLabel;
	private JTextField nameField, ageField, numField;
	private JRadioButton male, female;
	private JButton addButton, updateButton, deleteButton, closeButton;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private ButtonGroup group;

	public Exam0220() {
		super("숙제");
		
		nameLabel = new JLabel("이름");
		ageLabel = new JLabel("나이");
		genderLabel = new JLabel("성별");
		numLabel = new JLabel("전화번호");
		nameField = new JTextField(10);
		ageField = new JTextField(10);
		male = new JRadioButton("남");
		male.setActionCommand("남");
		female = new JRadioButton("여");
		female.setActionCommand("여");
		numField = new JTextField(10);

		group = new ButtonGroup();
		group.add(male);
		group.add(female);

		JPanel jpNorth = new JPanel(new GridLayout(4, 2));
		jpNorth.add(nameLabel);
		jpNorth.add(nameField);
		jpNorth.add(ageLabel);
		jpNorth.add(ageField);
		jpNorth.add(genderLabel);
		JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		genderPanel.add(male);
		genderPanel.add(female);
		jpNorth.add(genderPanel);
		jpNorth.add(numLabel);
		jpNorth.add(numField);

		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);

		JPanel buttonPanel = new JPanel(new FlowLayout());
		addButton = new JButton("추가");
		updateButton = new JButton("변경");
		deleteButton = new JButton("삭제");
		closeButton = new JButton("종료");

		buttonPanel.add(addButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(closeButton);

		add("West", jpNorth);
		add("Center", scrollPane);
		add("South", buttonPanel);
		
		Exam0220.InnerEvent ie = this.new InnerEvent();
		addButton.addActionListener(ie);
		deleteButton.addActionListener(ie);
		updateButton.addActionListener(ie);
		closeButton.addActionListener(ie);

		setVisible(true);
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public class InnerEvent implements ActionListener {

		public void add() {
			String text = nameField.getText() + "," + ageField.getText() + "," + group.getSelection().getActionCommand()
					+ "," + numField.getText();
			listModel.addElement(text);
		}

		public void update() {
			String newName = nameField.getText();
			String newAge = ageField.getText();
			String newGroup = group.getSelection().getActionCommand();
			String newNum = numField.getText();

			for (int i = 0; i < listModel.getSize(); i++) {
				String item = listModel.getElementAt(i);
				String[] parts = item.split(",");

				if (parts[0].equals(newName)) {
					String updateText = newName + "," + newAge + "," + newGroup + "," + newNum;
					listModel.setElementAt(updateText, i);
				}
			}
		}

		public void delete() {
			int selectedIndex = list.getSelectedIndex();
			if (selectedIndex != -1) {
				listModel.remove(selectedIndex);
			}
		}

		@Override
		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == addButton) {
				add();
				return;
			}
			if (ae.getSource() == updateButton) {
				update();
				return;
			}
			if (ae.getSource() == deleteButton) {
				delete();
				return;
			}
			if (ae.getSource() == closeButton) {
				dispose();
			}
		}

	}

	public static void main(String[] args) {
		new Exam0220();
	}

}
