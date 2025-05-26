package kr.co.sist.place;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.board.BoardDAO;
import kr.co.sist.board.BoardDTO;
import kr.co.sist.board.RangeDTO;

public class PlaceService {
	
	/**
	 * 맛집을 추가
	 * @param mDTO 식당명,메뉴,가격,정보,위도,경도,ip,id
	 * @return flag 성공시 true, 실패시 false 반환
	 */
	public boolean addRestaurant(RestDTO rDTO) {
		boolean flag = false;
		
		PlaceDAO pDAO = PlaceDAO.getInstance();
		
		try {
			pDAO.insertRestaurant(rDTO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //addRestaurant
	
	/**
	 * 시작번호와 끝 번호 사이의 게시물 조회
	 * @param rDTO
	 * @return list 조회한 게시물 리스트
	 */
	public List<RestDTO> searchAllRestaurant(RangeDTO rDTO){
		List<RestDTO> list = null;
		
		PlaceDAO pDAO = PlaceDAO.getInstance();
		try {
			list = pDAO.selectAllRestaurant(rDTO);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return list;
	} //searchAllRestaurant
	
	/**
	 * 총 레코드의 수
	 * @param rDTO
	 * @return cnt 레코드의 수
	 */
	public int totalCount( RangeDTO rDTO ) {
		int cnt = 0;
		
		PlaceDAO pDAO = PlaceDAO.getInstance();
		
		try {
			cnt = pDAO.selectTotalCount(rDTO);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return cnt;
	} //totalCount
	
	/**
	 * 레코드의 수 변경
	 * @param num
	 */
	public void modifyCnt(int num) {
		BoardDAO bDAO = BoardDAO.getInstance();
		
		try {
			bDAO.updateCnt(num);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
	} //modifyCnt
	
	/**
	 * 한 화면에 출력할 게시물의 수
	 * @return pageScale 출력할 게시물의 수
	 */
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	} //pageScale
	
	/**
	 * 총 페이지 수
	 * @param totalCount 총 게시물의 수
	 * @param pageScale 한 화면에 출력할 게시물의 수
	 * @return totalPage 총 페이지 수
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage= 0;
		
		totalPage = (int)(Math.ceil((double)totalCount/pageScale));
		
		return totalPage;
	} //totalPage
	
	/**
	 * pagination 을 클릭했을 때 번호를 사용하여 해당 페이지 게시물 시작 번호
	 * 예) 1=1, 2=11, 3=21, 4=31, 5=41
	 * @param pageScale 한 화면에 출력할 게시물의 수
	 * @param rDTO
	 * @return startNum 해당 페이지 게시물 시작 번호
	 */
	public int startNum(int pageScale, RangeDTO rDTO) {
		int startNum = 1;
		
		startNum = rDTO.getCurrentPage()*pageScale-pageScale+1;
		rDTO.setStartNum(startNum);
		
		return startNum;
	} //startNum
	
	/**pagination 을 클릭했을 때 번호를 사용하여 해당 페이지 게시물 끝 번호
	 * @param pageScale 한 화면에 출력할 게시물의 수
	 * @param rDTO
	 * @return endNum 해당 페이지 게시물 끝 번호
	 */
	public int endNum(int pageScale, RangeDTO rDTO) {
		int endNum = 0;
		
		endNum = rDTO.getStartNum()+pageScale-1;
		rDTO.setEndNum(endNum);
		
		return endNum;
	} //endNum
	
	public RestDTO searchOneRestaurant(int num) {
		RestDTO rDTO = null;
		
		PlaceDAO pDAO = PlaceDAO.getInstance();
		try {
			rDTO = pDAO.selectOneRestaurant(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rDTO;
	}//searchOneBoard

} //class
