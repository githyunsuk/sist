package day0515;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

public class DeptDAO {

	private static DeptDAO dDAO;
	
	private DeptDAO() {
		
	}
	
	public static DeptDAO getInstance() {
		if(dDAO == null) {
			dDAO = new DeptDAO();
		}
		
		return dDAO;
	}
	
	public List<Dept> selectAllDept() throws SQLException {
		List<Dept> list = new ArrayList<Dept>();
		
		DbConnection dbCon = DbConnection.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbCon.getDbConn();
			String selectAllDept = "select deptno, dname, loc from dept";
			pstmt = con.prepareStatement(selectAllDept);
			rs = pstmt.executeQuery();
			
			Dept deptDto = null;
			while(rs.next()) {
				deptDto = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				list.add(deptDto);
			}
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return list;
	}
}
