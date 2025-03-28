package day0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;

/**
 * 여러개의 쿼리문으로 하나의 DB작업이 구성되는 경우. (transaction이 여러개의 쿼리문으로 구성)
 */
public class TransactionDAO {

	private Connection con;

	/**
	 * 입력된 이름과 주소를 test_transaction, test_transaction2 테이블에 추가
	 * 
	 * @param con
	 * @param name
	 * @param addr
	 * @return
	 * @throws SQLException
	 */
	public int insertTransaction(Connection con, String name, String addr) throws SQLException {
		int totalRow = 0;
		// 테이블 하나에 insert 수행
		String insert = "insert into test_transaction(name,addr) values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(insert);
		int insertCnt = 0;

		pstmt.setString(1, name);
		pstmt.setString(2, addr);

		insertCnt = pstmt.executeUpdate();
		System.out.println("처음 테이블 추가 성공");

		// 다른 테이블에 insert 수행
		String insert2 = "insert into test_transaction2(name,addr) values(?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(insert2);
		int insertCnt2 = 0;

		pstmt2.setString(1, name);
		pstmt2.setString(2, addr);

		insertCnt2 = pstmt2.executeUpdate();
		System.out.println("두번째 테이블 추가 성공");

		totalRow = insertCnt + insertCnt2;

		return totalRow;
	}// insertTransaction

	/**
	 * 여러개의 쿼리문이 하나의 트랜잭션을 구성되는 method 호출
	 */
	public void userInsertTransaction() throws SQLException {
		DbConnection dbc = DbConnection.getInstance();

		Connection con = dbc.getConn();
		con.setAutoCommit(false); //auto commit 해제
		try {

			String name = "강태삼";
			String addr = "인천시에 삼";

			// 여러개의 쿼리문을 실행
			int cnt = insertTransaction(con, name, addr);

			if (cnt == 2) {
				con.commit();
				System.out.println("commit");
			} /*else {
				con.rollback(); update나 delete
			}*/
		} catch (SQLException se) {
			se.printStackTrace();
			con.rollback();
			System.out.println("rollback");
		} finally {
			if (con != null)
				con.close();
		}

	}// userInsertTransaction

	public static void main(String[] args) {
		TransactionDAO tDAO = new TransactionDAO();
		try {
			tDAO.userInsertTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main

}// class
