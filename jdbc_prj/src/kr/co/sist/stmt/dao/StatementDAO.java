package kr.co.sist.stmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.StatementMemberVO;

/**
 * CRUD (create, read, update, delete) C: create, insert R: select U: update,
 * alter D: delete, drop, truncate
 * 
 */
public class StatementDAO {

	/**
	 * STATEMENT_MEMBER 테이블에 레코드를 추가하는 일. 추가 성공 아니면 예외
	 * 
	 * @param smVO 추가할 값
	 * @throws SQLException 예외
	 */
	public void insertStmtMember(StatementMemberVO smVO) throws SQLException {
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 로딩된 드라이버를 사용하여 Connection 얻기
		Connection conn = null;
		Statement stmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			// 3. Connection에서 쿼리문 생성객체 얻기
			stmt = conn.createStatement();
			// 4. 쿼리문 실행 후 결과 얻기
			StringBuilder insertStmtMember = new StringBuilder();
			insertStmtMember.append("insert into statement_member(num,name,age,gender,tel)")
					.append("values(seq_stmt.nextval, '").append(smVO.getName()).append("',").append(smVO.getAge())
					.append(", '").append(smVO.getGender()).append("','").append(smVO.getTel()).append("')");

			stmt.executeUpdate(insertStmtMember.toString());

		} finally {
			// 5. 연결 끊기
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	/**
	 * STATEMENT_MEMBER 테이블의 레코드를 변경하는 일 번호를 사용하여 나이와 전화번호를 변경하는 일 0건: 조건에 사용되는 값이
	 * 잘못되었을 때 n건: 조건에 사용되는 값에 해당하는 레코드가 여러행일 때 예외: 쿼리문이 잘못된 경우, DBMS연동에 문제가 발생
	 * 
	 * @param smVO - 변경할 값을 가진 객체
	 * @return - 변경된 행의 수
	 * @throws SQLException - 예외
	 */
	public int updateStmtMember(StatementMemberVO smVO) throws SQLException {
		int rowCnt = 0; // 변경된 행의 수를 저장할 메서드

		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, id, pass);
			// 3.쿼리문 생성객체 얻기
			stmt = conn.createStatement();
			// 4.쿼리문 수행 후 결과 얻기
			StringBuilder updateMember = new StringBuilder();
			updateMember.append("	update	statement_member	").append("	set	age=").append(smVO.getAge())
					.append(", tel='").append(smVO.getTel()).append("'").append("	where	num=")
					.append(smVO.getNum());

			rowCnt = stmt.executeUpdate(updateMember.toString());
		} finally {
			// 5.연결 끊기
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

		return rowCnt;
	}

	/**
	 * STATEMENT_MEMBER 테이블의 레코드를 삭제하는 일 번호를 사용하여 나이와 전화번호를 변경하는 일 0건: 조건에 사용되는 값이
	 * 잘못되었을 때 n건: 조건에 사용되는 값에 해당하는 레코드가 여러행일 때 예외: 쿼리문이 잘못된 경우, DBMS연동에 문제가 발생
	 * 
	 * @param smVO - 변경할 값을 가진 객체
	 * @return - 변경된 행의 수
	 * @throws SQLException - 예외
	 */
	public int deleteStmtMember(int num) throws SQLException {
		int rowCnt = 0;

		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, id, pass);
			// 3.쿼리문 생성객체 얻기
			stmt = conn.createStatement();
			// 4.쿼리문 수행 후 결과 얻기
			StringBuilder deleteMember = new StringBuilder();
			deleteMember
			.append("	delete from	statement_member	")
			.append("	where num=").append(num);
			

			rowCnt = stmt.executeUpdate(deleteMember.toString());
		} finally {
			// 5.연결 끊기
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

		return rowCnt;
	}

	/**
	 * STATEMENT_MEMBER 테이블의 모든 레코드를 검색하는 일. 검색된 레코드 하나를 vo에 저장하고, 모든 vo객체를 List에
	 * 저장하여 반환.
	 * 
	 * @return 모든 레코드를 가진 리스트
	 * @throws SQLException 예외
	 */
	public List<StatementMemberVO> selectAllStmtMember() throws SQLException {
		List<StatementMemberVO> list = new ArrayList<StatementMemberVO>();

		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		try {
		//2.커넥션 얻기
			conn = DriverManager.getConnection(url,id,pass);
		//3.쿼리문 생성객체 얻기
			stmt = conn.createStatement();
		//4.쿼리문 수행 후 결과 얻기
			StringBuilder selectAllMember = new StringBuilder();
			selectAllMember
			.append("	select	num,name,age,gender,tel,input_date	")
			.append("	from	statement_member		");
			
			rs = stmt.executeQuery(selectAllMember.toString());
			//쿼리를 수행 한 후 inline view 앞에 생성된 cursor의 제어권을 얻기
			
			//몇 줄의 레코드가 있는지 알 수 없다.
			StatementMemberVO smVO = null;
			while(rs.next()) {
				smVO = new StatementMemberVO();
				smVO.setNum(rs.getInt("num"));
				smVO.setName(rs.getString("name"));
				smVO.setAge(rs.getInt("age"));
				smVO.setGender(rs.getString("gender"));
				smVO.setTel(rs.getString("tel"));
				smVO.setInputDate(rs.getDate("input_date"));
				
//				System.out.println(smVO);
				//레코드의 컬럼값을 가진 VO객체를 List에 추가
				list.add(smVO);
			}
			System.out.println(list);
		}finally {
		//5.연결 끊기
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		return list;
	}

	/**
	 * STATEMENT_MEMBER 테이블에서 번호에 해당하는 레코드 하나를 검색하는 일.
	 * 
	 * @param num 번호
	 * @return 레코드 하나를 가진 VO객체
	 * @throws SQLException 예외
	 */
	public StatementMemberVO selectOneStmtMember(int num) throws SQLException {
		StatementMemberVO smVO = null;

		return smVO;
	}
	
	/**
	 * STATEMENT_MEMBER 테이블에 모든 레코드의 수를 얻기
	 * @return 레코드의 수
	 * @throws SQLException
	 */
	public int selectCntStmtMember() {
		int cnt = 0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		//2.커넥션 얻기
		//3.쿼리문 생성객체 얻기
		//5.자동으로 연결이 끊어진다. try~with~resources
		String selectAllCnt = "select count(num) cnt from statement_member";
		try(Connection con = DriverManager.getConnection(url,id,pass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectAllCnt)) {
			
			//4.쿼리문 실행 후 결과 얻기
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch(SQLException se) {
			se.printStackTrace();
		}
		
		
		
		
		return cnt;
	}
}
