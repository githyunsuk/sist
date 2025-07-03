package kr.co.sist.annotation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

/**
 *DBMS의 업무 목록을 구현 
 */
@Repository("mySql")
public class MySqlDAOImpl implements DAO{

	@Override
	public int insert(TestDTO tDTO) throws SQLException {
		int cnt=new Random().nextInt(2);
		if(cnt == 0) {
			throw new SQLException("MySql DB 추가실패!!");
		}//end if
		System.out.println("MySql DB 추가성공!!");
		return cnt;
	}

	@Override
	public List<TestDomain> select() throws SQLException {
		List<TestDomain> list=new ArrayList<TestDomain>();
		list.add(new TestDomain("강태일",21));
		list.add(new TestDomain("강태이",22));
		list.add(new TestDomain("강태삼",23));
		list.add(new TestDomain("강태사",24));
		list.add(new TestDomain("강태오",25));
		
		return list;
	}

}
