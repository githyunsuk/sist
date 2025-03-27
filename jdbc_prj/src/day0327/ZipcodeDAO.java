package day0327;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

public class ZipcodeDAO {

	private static ZipcodeDAO zDAO;

	private ZipcodeDAO() {
		// 싱클톤 패턴
	}

	public static ZipcodeDAO getInstance() {
		if (zDAO == null) {
			zDAO = new ZipcodeDAO();
		}
		return zDAO;
	}// getInstance

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbCon = DbConnection.getInstance();

		try {
			con = dbCon.getConn();
			StringBuilder selectZicode = new StringBuilder();
			selectZicode.append("	select zipcode, sido, gugun, dong,		")
					.append("	nvl(bunji,' ') bunji					")
					.append("	from zipcode							")
					.append("	where dong like ?||'%'					");

			pstmt = con.prepareStatement(selectZicode.toString());

			pstmt.setString(1, dong);

			rs = pstmt.executeQuery();

			ZipcodeVO zVO = null;
			while (rs.next()) {
				zVO = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				
				list.add(zVO);
			}
		} finally {
			dbCon.closeDB(rs, pstmt, con);
		}
		return list;
	}// selectZipcode
	
	public List<ZipcodeVO> selectStmtZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		DbConnection dbCon = DbConnection.getInstance();

		try {
			con = dbCon.getConn();
			StringBuilder selectZicode = new StringBuilder();
			selectZicode.append("	select zipcode, sido, gugun, dong,		")
					.append("	nvl(bunji,' ') bunji					")
					.append("	from zipcode							")
					.append("	where dong like '").append(blockInjection(dong)).append("%'");

			stmt = con.createStatement();
			
//			pstmt.setString(1, dong);

			rs = stmt.executeQuery(selectZicode.toString());
			
			ZipcodeVO zVO = null;
			while (rs.next()) {
				zVO = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				
				list.add(zVO);
			}
		} finally {
			dbCon.closeDB(rs, stmt, con);
		}
		return list;
	}// selectZipcode
	
	public String blockInjection(String sql) {
		String temp=sql;
		if(temp == null && !temp.isEmpty()) {
			temp = temp.replaceAll("'", "").replaceAll(" ", "")
					   .replaceAll("--", "");
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
	}

}
// class
