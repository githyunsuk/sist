package kr.co.sist.stmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.StatementMemberVO;

/**
 * CRUD (create, read, update, delete)
 * C: create, insert
 * R: select
 * U: update, alter
 * D: delete, drop, truncate
 *  
 */
public class StatementDAO {

	/**
	 * STATEMENT_MEMBER 테이블에 레코드를 추가하는 일.
	 * 추가 성공 아니면 예외
	 * @param smVO 추가할 값
	 * @throws SQLException 예외
	 */
	public void insertStmtMember(StatementMemberVO smVO) throws SQLException {
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2. 로딩된 드라이버를 사용하여 Connection 얻기
		Connection conn = null; 
		Statement stmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			//3. Connection에서 쿼리문 생성객체 얻기
			stmt = conn.createStatement();
			//4. 쿼리문 실행 후 결과 얻기
			StringBuilder insertStmtMember = new StringBuilder();
			insertStmtMember
			.append("insert into statement_member(num,name,age,gender,tel)")
			.append("values(seq_stmt.nextval, '").append(smVO.getName())
			.append("',").append(smVO.getAge())
			.append(", '").append(smVO.getGender())
			.append("','").append(smVO.getTel()).append("')");
			
			stmt.executeUpdate(insertStmtMember.toString());
			
		} finally {
			//5. 연결 끊기
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	}
	
	/**
	 * STATEMENT_MEMBER 테이블의 레코드를 변경하는 일
	 * 번호를 사용하여 나이와 전화번호를 변경하는 일
	 * 0건: 조건에 사용되는 값이 잘못되었을 때
	 * n건: 조건에 사용되는 값에 해당하는 레코드가 여러행일 때
	 * 예외: 쿼리문이 잘못된 경우, DBMS연동에 문제가 발생
	 * @param smVO - 변경할 값을 가진 객체
	 * @return - 변경된 행의 수
	 * @throws SQLException - 예외
	 */
	public int updateStmtMember(StatementMemberVO smVO) throws SQLException{
		int rowCnt = 0; //변경된 행의 수를 저장할 메서드
		
		return rowCnt;
	}
	
	/**
	 * STATEMENT_MEMBER 테이블의 레코드를 삭제하는 일
	 * 번호를 사용하여 나이와 전화번호를 변경하는 일
	 * 0건: 조건에 사용되는 값이 잘못되었을 때
	 * n건: 조건에 사용되는 값에 해당하는 레코드가 여러행일 때
	 * 예외: 쿼리문이 잘못된 경우, DBMS연동에 문제가 발생
	 * @param smVO - 변경할 값을 가진 객체
	 * @return - 변경된 행의 수
	 * @throws SQLException - 예외
	 */
	public int deleteStmtMember(int num) throws SQLException{
		int rowCnt = 0;
		
		return rowCnt;
	}
	
	/**
	 * STATEMENT_MEMBER 테이블의 모든 레코드를 검색하는 일.
	 * 검색된 레코드 하나를 vo에 저장하고, 모든 vo객체를 List에 저장하여 반환.
	 * @return 모든 레코드를 가진 리스트
	 * @throws SQLException 예외
	 */
	public List<StatementMemberVO> selectAllStmtMember() throws SQLException{
		List<StatementMemberVO> list = new ArrayList<StatementMemberVO>();
		
		return list;
	}
	
	/**
	 * STATEMENT_MEMBER 테이블에서 번호에 해당하는 레코드 하나를 검색하는 일.
	 * @param num 번호
	 * @return 레코드 하나를 가진 VO객체
	 * @throws SQLException 예외
	 */
	public StatementMemberVO selectOneStmtMember(int num) throws SQLException{
		StatementMemberVO smVO = null;
		
		return smVO;
	}
}
