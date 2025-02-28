package yys;

import javax.swing.*;

import java.awt.*;
import java.io.*;

public class LogAnalyzerGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JButton analyzeButton, reportButton;
    private JFileChooser fileChooser;
    private File selectedFile;
    
    public LogAnalyzerGUI() {
        frame = new JFrame("Log Analyzer");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        analyzeButton = new JButton("로그파일 분석");
        reportButton = new JButton("레포트 생성");
        
        Font font = new Font("맑은 고딕", Font.BOLD, 16);
        analyzeButton.setFont(font);
        reportButton.setFont(font);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(analyzeButton);
        buttonPanel.add(reportButton);
        panel.add(buttonPanel, BorderLayout.NORTH);
        
        frame.add(panel);
        frame.setVisible(true);
        
        fileChooser = new JFileChooser();
        analyzeButton.addActionListener(e -> analyzeLog());
        reportButton.addActionListener(e -> generateReport());
    }
    
    private void analyzeLog() {
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            
            if(selectedFile !=null && selectedFile.exists()) {
                LogAnalyzer analyzer = new LogAnalyzer();
                
                
                //7번. 라인 입력 부분
                int startLine=1;
                int endLine=1900;
                
                String result =  analyzer.analyze(selectedFile, startLine, endLine);
                textArea.setText(result);
            
        }else {
        	textArea.setText("유효한 로그 파일을 선택하세요");
        }
    }
    }
    private void generateReport() {
        if (selectedFile == null) {
            textArea.setText("로그 분석 후 레포트를 생성하세요.");
            return;
        }
        
        ReportGenerator.generateReport(textArea.getText());
        textArea.append("\n레포트 저장 완료");
    }
}

