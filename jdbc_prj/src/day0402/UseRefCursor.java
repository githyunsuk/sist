package day0402;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConnection;

public class UseRefCursor {

	public void selectCar(String maker) throws SQLException{
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		DbConnection db = DbConnection.getInstance();
		
		try {
			con = db.getConn();
			cstmt = con.prepareCall("{ call select_car(?,?,?)}");
			cstmt.setString(1, maker);
			cstmt.registerOutParameter(2, Types.REF_CURSOR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			
			cstmt.execute();
			
			rs = (ResultSet)cstmt.getObject(2);
			String errm = cstmt.getString(3);
			
			String model = "", car_year = "", car_option = "";
			int price = 0;
			while(rs.next()) {
				model = rs.getString("model");
				car_year = rs.getString("car_year");
				car_option = rs.getString("car_option");
				price = rs.getInt("price");
				
				System.out.println(model + "," + car_year + "," + car_option + "," + price );
			}
		} finally {
			db.closeDB(rs, cstmt, con);
		}
	}
	public static void main(String[] args) {
		try {
			new UseRefCursor().selectCar("현대");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
