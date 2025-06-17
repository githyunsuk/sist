package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDAO {
	private static MyBatisDAO mbDAO;
	
	private static SqlSessionFactory ssf; 
	
	private String configPath;
	
	private MyBatisDAO(String configPath) {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
		this.configPath=configPath;
	}//MyBatisDAO
	
	/**
	 * MyBatis Framework에서 연동할 DB의 설정을 가진 경로를 상대경로로 설정<br>
	 * 예) 상대경로는 : 패키지명/설정파일명.xml 로 설정
	 * 		kr/co/sist/dao/mbatis-config.xml
	 * @param configPath
	 * @return
	 */
	public static MyBatisDAO getInstance( String configPath ) {
		if( mbDAO == null) {
			mbDAO = new MyBatisDAO( configPath );
		}//end if
		return mbDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory( ) {
		if(ssf == null ) {
			try {
				//1.설정파일과(mybatis-config.xml)과 스트림으로 연결
				Reader reader = Resources.getResourceAsReader(configPath);
				//2.MyBatis Framework 생성
				ssf=new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end if
		
		return ssf;
	}//getSqlSessionFactory
	
	/**
	 * autocommit이 해제된 상태의 MyBatix의 Handler 얻기
	 * @return
	 */
	public SqlSession getMyBatisHandler( ) { 
		SqlSession ss=getMyBatisHandler(false);
		return ss;
	}//getMyBatisHandler
	
	/**
	 * autocommit을 설정하는 MyBatix의 Handler 얻기
	 * @param autoCommitFlag true, false
	 * @return
	 */
	public SqlSession getMyBatisHandler( boolean autoCommitFlag ) { 
		SqlSession ss=getSqlSessionFactory().openSession(autoCommitFlag);
		return ss;
	}//getMyBatisHandler
	
}//class
