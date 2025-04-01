package day0401;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConnection;

public class UsePlusProc {

	public UsePlusProc() throws SQLException {

		// 1.드라이버 로딩
		// 2.커넥션 얻기
		Connection con = null;
		CallableStatement cstmt = null;

		DbConnection db = DbConnection.getInstance();

		try {
			con = db.getConn();
			// 3.프로시저 호출 객체 얻기
			cstmt = con.prepareCall("{ call proc_plus(?,?,?,?) }");
			// 4.바인드 변수에 값 설정
			int i = 2025;
			int j = 4;
			// in parameter
			cstmt.setInt(1, i);
			cstmt.setInt(2, j);
			// out parameter => java에서는 Oracle의 bind 변수는 선언 할 수 없다.
			// 대체 method 사용.
			cstmt.registerOutParameter(3, Types.NUMERIC);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			while (true) {
				// 5.프로시저 실행
				cstmt.execute();
				// 6.out parameter에 저장된 값 받기
				int result = cstmt.getInt(3);
				String msg = cstmt.getString(4);
				System.out.println(result);
				System.out.println(msg);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			db.closeDB(null, cstmt, con);
		}
	}

	public static void main(String[] args) {
		try {
			new UsePlusProc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
