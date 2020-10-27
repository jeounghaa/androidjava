package com.mega.mvc03;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	MemberDAO dao;
	
	//아이디 중복 체크
	public String[] idCheck(String idid) {
		String[] name = { "root", "admin", "apple", "melon", "mint" };
		List<String> list = Arrays.asList(name);
		String page = "ok";
		String result = "사용 가능";
		if (list.contains(idid)) {
			result = "중복";
			page = "no";
		}
		String[] values = {result, page};
		return values;
	}
	
	public int price(int price) {
		if (price >= 10000) {
			price = price - 1000;
		}
		return price;
	}
}
