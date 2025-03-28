package day0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.sist.dao.DbConnection;

public class LoginDAO {

	private static LoginDAO lDAO;

	private LoginDAO() {

	}

	public static LoginDAO getInstance() {
		if (lDAO == null) {
			lDAO = new LoginDAO();
		}
		return lDAO;

	}// getInstance

	/**
	 * 로그인에 사용되는 method로 사용자의 아이디와 비밀번호를 입력받아서 이름을 반환하는 일
	 * 
	 * @param lVO 로그인에 사용될 아이디와 비번
	 * @return 검색된 이름
	 * @throws SQLException
	 */
	public String selectLogin(LoginVO lVO) throws SQLException {
		String name = "";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DbConnection dbCon = DbConnection.getInstance();
		try {
			conn = dbCon.getConn();
			stmt = conn.createStatement();
			StringBuilder selectName = new StringBuilder();
			selectName.append("	select	name		").append("	from	test_member	").append("	where id='")
					.append(lVO.getId()).append("' and pass='").append(lVO.getPass()).append("'");

			System.out.println(selectName);

			rs = stmt.executeQuery(selectName.toString());

			if (rs.next()) {
				name = rs.getString("name");
			}
		} finally {
			dbCon.closeDB(rs, stmt, conn);
		}
		return name;
	}// selectLogin

	public String selectPstmtLogin(LoginVO lVO) throws SQLException {
		String name = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbCon = DbConnection.getInstance();
		try {
			conn = dbCon.getConn();
			StringBuilder selectName = new StringBuilder();
			selectName.append("	select	name			").append("	from	test_member		")
					.append("	where 	id=? and pass=?	");

			pstmt = conn.prepareStatement(selectName.toString());

			pstmt.setString(1, lVO.getId());
			pstmt.setString(2, lVO.getPass());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}
		} finally {
			dbCon.closeDB(rs, pstmt, conn);
		}
		return name;
	}// selectLogin

	public String blockInjection(String sql) {
		String temp = sql;
		if (temp != null && !temp.isEmpty()) {
			temp = temp.replaceAll("'", "").replaceAll(" ", "").replaceAll("--", "");
		}

		return temp;
	}//blockInjection
}
