package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *DBMS의 업무 목록을 구현 
 */
public class OracleDAOImpl implements DAO{

	@Override
	public int insert(TestDTO tDTO) throws SQLException {
		int cnt=new Random().nextInt(2);
		if(cnt == 0) {
			throw new SQLException("Oracle DB 추가실패!!");
		}//end if
		System.out.println("Oracle DB 추가성공!!");
		return cnt;
	}

	@Override
	public List<TestDomain> select() throws SQLException {
		List<TestDomain> list=new ArrayList<TestDomain>();
		list.add(new TestDomain("이장훈",20));
		list.add(new TestDomain("삼장훈",30));
		list.add(new TestDomain("사장훈",40));
		
		return list;
	}

}
