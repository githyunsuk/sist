package kr.co.sist.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.vo.LobVO;

public class LobDAO {
	
	private static LobDAO LDAO;
	
	private LobDAO() {
	}//LobDAO
	
	public static LobDAO getInstance() {
		if( LDAO==null) {
			LDAO=new LobDAO();
		}//end if
		return LDAO;
	}//getInstance

	public void insertLob( LobVO lVO )throws SQLException {
		
		//1.
		//2.
		Connection con=null;
		PreparedStatement pstmt=null;
		DbConnection dbConn=DbConnection.getInstance();
		
		FileInputStream fis=null;
		try {
			con=dbConn.getConn();
		//3.
			StringBuilder insertLob=new StringBuilder();
			insertLob
			.append("insert into lob_data")
			.append("(num,name,email,tel,");
			if ( !lVO.getImg_name().isEmpty() ) {
				insertLob.append("img,img_name,");
			}//end if
			insertLob.append("intro)")
			.append("values")
			.append("(seq_lob.nextval,?,?,?,");
			if( !lVO.getImg_name().isEmpty() ) {
				insertLob.append("?,?,");
			}
			insertLob.append("?)");
			
			pstmt=con.prepareStatement( insertLob.toString() );
		//4.
			int bindInd=0;
			pstmt.setString(++bindInd, lVO.getName() );
			pstmt.setString(++bindInd, lVO.getEmail() );
			pstmt.setString(++bindInd, lVO.getTel() );
			
			if( !lVO.getImg_name().isEmpty() ) {
				File file=new File(lVO.getImg_name());
				if(file.exists() ) {
					 	fis=new FileInputStream(file);
						pstmt.setBinaryStream(++bindInd, fis, file.length());
						pstmt.setString(++bindInd, file.getName() );
				}//end if
			}//end if

			pstmt.setString(++bindInd, lVO.getIntro());
			System.out.println( bindInd );
		
		//5.
			pstmt.executeUpdate();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {	
		//6.
			dbConn.closeDB(null, pstmt, con);
			try {
				if( fis != null ) { 
				fis.close();}
			} catch (IOException ie) {
				ie.printStackTrace();
			 } //end if
		}//end finally
			
	}//insertLob
	
	public LobVO selectLob(int num)throws SQLException ,IOException{
		LobVO lVO=null;
		
		//1.
		//2.
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		InputStream is=null;//blob
		FileOutputStream fos=null;//blob
		
		BufferedReader br=null;//clob
		
		DbConnection dbCon=DbConnection.getInstance();
		try {
			con=dbCon.getConn();
			StringBuilder selectLob=new StringBuilder();
			selectLob
			.append("	select	name,email,tel,img,img_name,intro,input_date") 
			.append("	from	lob_data									") 
			.append("	where	num=.										"); 
		//3.
			pstmt=con.prepareStatement(selectLob.toString());
		//4.
			pstmt.setInt(1, num);
		//5
			rs=pstmt.executeQuery();
			
			if(rs.next() ) {
				//name,email,tel,img,img_name,intro,input_date
				lVO=new LobVO();
				lVO.setName(rs.getString("name"));
				lVO.setEmail(rs.getString("email"));
				lVO.setTel(rs.getString("tel"));
				lVO.setImg_name(rs.getString("Img_name"));
				lVO.setInput_date(rs.getTimestamp("input_date"));
				
				//Clob
				
				Clob introClob=rs.getClob("intro");
				if(introClob != null ) {
					
						br=new BufferedReader( introClob.getCharacterStream() );
						
						String tempIntro="";
						StringBuilder sbIntro=new StringBuilder();
						
						while( (tempIntro=br.readLine()) != null ) {
							sbIntro.append(tempIntro).append("\n");
						}//end while
						
						lVO.setIntro(sbIntro.toString());
					
					
				}//end if
				
				//Blob
				is=rs.getBinaryStream("img");
				if( is != null ) {
					File dir=new File("c:/dev/img");
					if( !(dir.exists()) ) {
						dir.mkdirs();
					}//end if
					File saveFile=new File(dir.getAbsoluteFile()+
						File.separator+	lVO.getImg_name());
					
					fos=new FileOutputStream(saveFile);
					
					byte[] readImg=new byte[512];
					
					int dataLength=0;
					
					while( (dataLength=is.read(readImg)) != -1 ) {
						fos.write(readImg, 0, dataLength);
					}
					fos.flush();
				}//end if
				
				
			}//end if
			
		}finally {
			if(br != null) { br.close(); } //end if
			
			if( is != null) { is.close();}//end if
			if( fos != null) { fos.close();}//end if
			dbCon.closeDB(rs, pstmt, con);
		}

		//6.
		
		return lVO;
	}
	
	public static void main(String[] args) {
		LobVO lVO=new LobVO(0, null,null,null, 
			null,"C:/Users/user/Desktop/05.이미지/default_img.png",
null, null);
		
		try {
//			LobDAO.getInstance().insertLob(lVO);
			LobDAO.getInstance().selectLob(4);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}//class
