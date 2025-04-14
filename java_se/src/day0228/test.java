package day0228;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class test extends JPanel implements ActionListener {
	private double angle = 0;
	private Timer timer;
	private boolean spinning = false;
	private double speed = 0;
	private Random rand = new Random();

	public test() {
		timer = new Timer(20, this); // 50fps 정도
		JButton btn = new JButton("돌리기!");
		btn.addActionListener(e -> {
			if (!spinning) {
				speed = rand.nextDouble() * 10 + 10; // 랜덤한 시작 속도
				spinning = true;
				timer.start();
			}
		});
		this.setLayout(new BorderLayout());
		this.add(btn, BorderLayout.SOUTH);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawRoulette((Graphics2D) g);
	}

	private void drawRoulette(Graphics2D g2d) {
		int size = Math.min(getWidth(), getHeight()) - 100;
		int x = (getWidth() - size) / 2;
		int y = (getHeight() - size) / 2;

		g2d.translate(getWidth() / 2, getHeight() / 2);
		g2d.rotate(Math.toRadians(angle));
		g2d.translate(-getWidth() / 2, -getHeight() / 2);

		g2d.setColor(Color.WHITE);
		g2d.fillOval(x, y, size, size); // 전체 배경을 흰색 원으로 칠함

		String[] labels = { "1등", "2등", "3등", "꽝", "다시!" };
		int segments = labels.length;

		g2d.setColor(Color.BLACK); // 테두리 색
		for (int i = 0; i < segments; i++) {
			g2d.drawArc(x, y, size, size, i * 360 / segments, 360 / segments); // 검정 테두리만
		}

		// 선으로 각 조각 나누기
		for (int i = 0; i < segments; i++) {
			double theta = Math.toRadians(i * 360.0 / segments);
			int x2 = getWidth() / 2 + (int) (Math.cos(theta) * size / 2);
			int y2 = getHeight() / 2 + (int) (Math.sin(theta) * size / 2);
			g2d.drawLine(getWidth() / 2, getHeight() / 2, x2, y2);
		}

		// 텍스트 그리기
		for (int i = 0; i < segments; i++) {
			double theta = Math.toRadians(i * 360.0 / segments + 360.0 / (2 * segments));
			int textX = getWidth() / 2 + (int) (Math.cos(theta) * size / 3);
			int textY = getHeight() / 2 + (int) (Math.sin(theta) * size / 3);
			g2d.drawString(labels[i], textX - 15, textY);
		}

		// 화살표 그리기
		g2d.setTransform(new AffineTransform()); // 초기화
		g2d.setColor(Color.BLACK);
		int[] px = { getWidth() / 2 - 10, getWidth() / 2 + 10, getWidth() / 2 };
		int[] py = { y - 20, y - 20, y };
		g2d.fillPolygon(px, py, 3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (spinning) {
			angle += speed;
			speed *= 0.98; // 점점 느리게
			if (speed < 0.1) {
				spinning = false;
				timer.stop();
				JOptionPane.showMessageDialog(this, "룰렛 멈춤!");
			}
			repaint();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("룰렛 예제");
		test roulette = new test();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(roulette);
		frame.setVisible(true);
	}
}
