package kr.co.sist.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.sist.dto.DeptVO;

public class FormPreService {

	public List<DeptVO> deptInfo(){
		List<DeptVO> list = new ArrayList<DeptVO>();
		
		list.add(new DeptVO(10, "SI"));
		list.add(new DeptVO(20, "QA"));
		list.add(new DeptVO(30, "SM"));
		list.add(new DeptVO(40, "SE"));
		
		return list;
	}
	
	public String today() {
		return new SimpleDateFormat("yyyy-MM-dd EEEE").format(new Date());
	}
}
