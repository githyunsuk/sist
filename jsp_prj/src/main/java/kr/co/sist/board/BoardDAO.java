package kr.co.sist.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.member.MemberDTO;

public class BoardDAO {

	public static BoardDAO bDAO;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		if (bDAO == null) {
			bDAO = new BoardDAO();
		}

		return bDAO;
	}// getInstance

	public int selectTotalCount(RangeDTO rDTO) throws SQLException {
		int cnt = 0;

		DbConnection db = DbConnection.getInstance();

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			// 1.JNDI 사용객체 생성
			// 2.DBCP에서 연결객체 얻기(DataSource)
			// 3.Connection 얻기
			con = db.getDbConn();
			// 4.쿼리문 생성객체 얻기
			StringBuilder selectIdQuery = new StringBuilder();
			selectIdQuery.append("	select count(num) cnt		").append("	from board	");

			pstmt = con.prepareStatement(selectIdQuery.toString());
			// 5.바인드 변수에 값 할당
			// 6.쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} finally {
			// 7.연결 끊기
			db.dbClose(rs, pstmt, con);
		}

		return cnt;
	}// selectId

	/**
	 * 시작번호와 끝번호 사이에 있는 레코드를 얻는 일.
	 * 
	 * @param rDTO
	 * @return
	 * @throws SQLException
	 */
	public List<BoardDTO> selectBoard(RangeDTO rDTO) throws SQLException {
		DbConnection db = DbConnection.getInstance();

		List<BoardDTO> list = new ArrayList<BoardDTO>();

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			// 1.JNDI 사용객체 생성
			// 2.DBCP에서 연결객체 얻기(DataSource)
			// 3.Connection 얻기
			con = db.getDbConn();
			// 4.쿼리문 생성객체 얻기
			StringBuilder selectBoard = new StringBuilder();
			selectBoard.append("	select num, subject, id, input_date, cnt	").append(
					"	from (select num, subject,id, input_date, cnt, row_number() over(order by input_date desc) rnum ")
					.append("	from board)		").append("	where rnum between ? and ?	");

			pstmt = con.prepareStatement(selectBoard.toString());
			// 5.바인드 변수에 값 할당
			pstmt.setInt(1, rDTO.getStartNum());
			pstmt.setInt(2, rDTO.getEndNum());
			// 6.쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			BoardDTO bDTO = null;
			while (rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setNum(rs.getInt("num"));
				bDTO.setCnt(rs.getInt("cnt"));
				bDTO.setSubject(rs.getString("subject"));
				bDTO.setId(rs.getString("id"));
				bDTO.setInput_date(rs.getDate("input_date"));

				list.add(bDTO);

			}
		} finally {
			// 7.연결 끊기
			db.dbClose(rs, pstmt, con);
		}

		return list;
	}// selectBoard
}
