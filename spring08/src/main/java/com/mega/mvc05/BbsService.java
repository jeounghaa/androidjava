package com.mega.mvc05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	
	@Autowired
	BbsDAO dao; // 전역변수

	// 전역변수의 주소/값을 넣는 방법
	// 1. 파라메터 있는 생성자를 사용
	// 2. set메서드를 사용
//	public BbsService(BbsDAO dao) {
//		this.dao = dao;
//	}

	public BbsVO one(BbsVO vo) {
		return dao.select(vo);
	}

	public void setDao(BbsDAO dao) {
		this.dao = dao;
	}

	public void create(BbsVO vo) {
		dao.insert(vo);
	}
	
	public List<BbsVO> all() {
		return dao.list();
	}
	
}
