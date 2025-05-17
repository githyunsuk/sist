package day0516;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

public class EmpDAO {

	private static EmpDAO dDAO;
	
	private EmpDAO() {
		
	}
	
	public static EmpDAO getInstance() {
		if(dDAO == null) {
			dDAO = new EmpDAO();
		}
		
		return dDAO;
	}
	
	public List<EmpDTO> selectEmp(int deptno) throws SQLException {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		DbConnection dbCon = DbConnection.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbCon.getDbConn();
			String selectAllDept = "select empno, ename, job, hiredate, sal from emp where deptno=?";
			pstmt = con.prepareStatement(selectAllDept);
			
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			EmpDTO empDto = null;
			while(rs.next()) {
				empDto = new EmpDTO();
				empDto.setEmpno(rs.getInt("empno"));
				empDto.setEname(rs.getString("ename"));
				empDto.setJob(rs.getString("job"));
				empDto.setHiredate(rs.getDate("hiredate"));
				empDto.setSal(rs.getInt("sal"));
				list.add(empDto);
			}
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return list;
	}
}
