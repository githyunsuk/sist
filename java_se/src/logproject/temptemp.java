package logproject;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class temptemp {

    private MainView mv;
    private ArrayList<LogVO> lvoList = new ArrayList<>();
    private Map<String, Integer> serviceMap = new HashMap<>();
    private Map<String, Integer> browserMap = new HashMap<>();
    private Map<String, Integer> keyMap = new HashMap<>();
    private Map<String, Integer> timeMap = new HashMap<>();

    private int books500Cnt = 0;
    private int startLine, endLine;

    public temptemp(MainView mv) throws IOException {
        this.mv = mv;

        File file = selectFile();
        if (file == null) return;

        readLogFile(file);
        processLogs();
        displayResults();
    }

    /** 파일 선택 */
    private File selectFile() {
        JFileChooser fileChooser = new JFileChooser("c:/dev");
        if (fileChooser.showOpenDialog(mv) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    /** 로그 파일 읽기 */
    private void readLogFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                lvoList.add(new LogVO(line));
            }
        }
    }

    /** 로그 처리 */
    private void processLogs() {
        startLine = mv.getInputLineFieldA().getText().isBlank() ? 1 : Integer.parseInt(mv.getInputLineFieldA().getText());
        endLine = mv.getInputLineFieldB().getText().isBlank() ? lvoList.size() : Integer.parseInt(mv.getInputLineFieldB().getText());

        for (int i = startLine - 1; i < endLine; i++) {
            LogVO log = lvoList.get(i);

            incrementCount(serviceMap, log.getService());
            incrementCount(browserMap, log.getBrowserName());
            incrementCount(keyMap, log.getKeyName());
            incrementCount(timeMap, log.getTime());

            if (log.isBooks() && "500".equals(log.getService())) {
                books500Cnt++;
            }
        }
    }

    /** 맵에 값 추가 */
    private void incrementCount(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    /** 결과 출력 */
    private void displayResults() {
        StringBuilder msg = new StringBuilder();

        // 1. 최다 사용 키
        String mostUsedKey = getMaxKey(keyMap);
        int maxKeyUsageCount = keyMap.getOrDefault(mostUsedKey, 0);
        msg.append("1. 최대 사용 키: ").append(mostUsedKey).append(", ").append(maxKeyUsageCount).append("회\n");

        // 2. 브라우저별 접속
        msg.append("2. 브라우저별 접속\n");
        for (var entry : browserMap.entrySet()) {
            msg.append(entry.getKey()).append(" - ")
               .append(entry.getValue()).append("회 [")
               .append(String.format("%.2f", (double) entry.getValue() / endLine * 100)).append("%]\n");
        }

        // 3. 서비스 성공(200), 실패(404) 횟수
        int serviceSucceed = serviceMap.getOrDefault("200", 0);
        int serviceFailed = serviceMap.getOrDefault("404", 0);
        msg.append("3. 서비스를 성공적으로 수행한 횟수: ").append(serviceSucceed).append("회, 실패 횟수: ").append(serviceFailed).append("회\n");

        // 4. 요청이 가장 많은 시간
        String mostUsedTime = getMaxKey(timeMap) + "시";
        msg.append("4. 요청이 가장 많은 시간: [").append(mostUsedTime).append("]\n");

        // 5. 비정상 요청(403) 발생 횟수 및 비율
        int count403 = serviceMap.getOrDefault("403", 0);
        msg.append("5. 비정상적인 요청(403)이 발생한 횟수: ").append(count403)
           .append(" [").append(String.format("%.2f", (double) count403 / endLine * 100)).append("%]\n");

        // 6. books 관련 에러(500) 발생 횟수 및 비율
        msg.append("6. books에 대한 요청 URL 중 에러(500)가 발생한 횟수: ").append(books500Cnt)
           .append(" [").append(String.format("%.2f", (double) books500Cnt / endLine * 100)).append("%]\n");

        mv.getJta().append(msg.toString());
    }

    /** 가장 많이 등장한 키 찾기 */
    private String getMaxKey(Map<String, Integer> map) {
        return map.entrySet().stream()
                  .max(Map.Entry.comparingByValue())
                  .map(Map.Entry::getKey)
                  .orElse("없음");
    }
}
