package kr.co.sist.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DataService {

	public List<String> searchNames(){
		List<String> list = new ArrayList<String>();
		list.add("이장훈");
		list.add("주현석");
		list.add("강태일");
		list.add("유연수");
		return list;
	}
	
	public Date nowDate() {
		return new Date();
	}
}
