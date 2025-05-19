package kr.co.sist.board;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
public class BoardService {

	/**
	 * 1.총 레코드의 수
	 * @param rDTO
	 * @return 레코드의 수
	 */
	public int totalCount(RangeDTO rDTO) {
		int cnt = 0;
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			cnt = bDAO.selectTotalCount(rDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 한 화면에 보여줄 게시물의 수
	 * @return
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}
	
	/**
	 * 총 페이지 수
	 * @param totalCount 총 게시물의 수
	 * @param pageScale 한화면에 보여줄 게시글의 수
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage = 0;
		
		totalPage = (int)Math.ceil((double)totalCount / pageScale);
		
		return totalPage;
	}
	
	/**
	 * pagination을 클릭했을 때의 번호를 사용하여 해당 페이지의 시작번호를 구하기
	 * 1 - 1, 2 - 11, 3 - 21
	 * @param pageScale
	 * @param rDTO
	 * @return
	 */
	public int startNum(int pageScale, RangeDTO rDTO) {
		int startNum = 1;
		
		startNum = rDTO.getCurrentPage() * pageScale - pageScale + 1;
		rDTO.setStartNum(startNum);
		return startNum;
	}
	
	/**
	 * pagination을 클릭했을 때의 번호를 사용하여 해당 페이지의 끝번호를 구하기
	 * @param pageScale
	 * @param rDTO
	 * @return
	 */
	public int endNum(int pageScale, RangeDTO rDTO) {
		int endNum = 0;
		
		endNum = rDTO.getStartNum() + pageScale - 1;
		rDTO.setEndNum(endNum);
		return endNum;
	}
	
	public List<BoardDTO> searchBoard(RangeDTO rDTO){
		List<BoardDTO> list = null;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			list = bDAO.selectBoard(rDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
