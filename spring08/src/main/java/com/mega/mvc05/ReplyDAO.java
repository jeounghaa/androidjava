package com.mega.mvc05;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// persistence layer(퍼시스턴스 레이어, 층)

@Repository
public class ReplyDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void create(ReplyVO vo) {
		int result = mybatis.insert("reply.create", vo);
	}
	
	public List<ReplyVO> list(int original) {
		List<ReplyVO> list = mybatis.selectList("reply.list", original);
		System.out.println("댓글 리스트" + list);
		return list;
	}
	
}
