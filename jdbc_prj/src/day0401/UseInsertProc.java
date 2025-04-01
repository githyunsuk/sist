package day0401;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import kr.co.sist.dao.DbConnection;

public class UseInsertProc {

	public void insertCpEmp(CpEmpVO ceVO) throws SQLException{
		Connection con = null;
		CallableStatement cstmt = null;
		
		DbConnection db = DbConnection.getInstance();
		try {
			con = db.getConn();
			cstmt = con.prepareCall("{ call insert_cp_emp(?,?,?,?,?,?) }");
			
			cstmt.setInt(1, ceVO.getEmpno());
			cstmt.setString(2, ceVO.getEname());
			cstmt.setString(3, ceVO.getJob());
			cstmt.setInt(4, ceVO.getSal());
			
			cstmt.registerOutParameter(5, Types.NUMERIC);
			cstmt.registerOutParameter(6,Types.VARCHAR);
			
			cstmt.execute();
			
			int cnt = cstmt.getInt(5);
			
			String msg = cstmt.getString(6);
			
			String outMsg = "추가실패";
			if(cnt == 1) {
				outMsg = "추가성공!!!";
			}
			JOptionPane.showMessageDialog(null, outMsg);
			System.out.println("PL/SQL에서 생성한 메시지" + msg);
			
		}finally {
			db.closeDB(null, cstmt, con);
		}
	}//insertCpEmp
	
	public static void main(String[] args) {
		CpEmpVO ceVO = new CpEmpVO();
		ceVO.setEmpno(2);
		ceVO.setEname("이장훈");
		ceVO.setJob("개발자");
		ceVO.setSal(3600);
		
		try {
			new UseInsertProc().insertCpEmp(ceVO);
			System.out.println("추가 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
