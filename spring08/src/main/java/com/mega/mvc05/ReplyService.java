package com.mega.mvc05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// controller에서 DB로 넘어가기 전 / 결과 값 가지고 와서
// 중간에 처리해야 하는 부분: 비즈니스 층(business layer) 

@Service
public class ReplyService {
	
	@Autowired
	ReplyDAO dao;
	
	public void create(ReplyVO vo) {
		dao.create(vo);
	}
	
	public List<ReplyVO> list(int original) {
		return dao.list(original);
	}
	
}
