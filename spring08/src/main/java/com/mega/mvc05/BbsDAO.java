package com.mega.mvc05;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insert(BbsVO vo) {
		mybatis.insert("bbs.create", vo);
	}
	
	public void update(BbsVO vo) {
		mybatis.update("bbs.update", vo);
	}
	
	public void delete(BbsVO vo) {
		mybatis.delete("bbs.delete", vo);
	}
	
	public BbsVO select(BbsVO vo) {
		BbsVO vo2 = mybatis.selectOne("bbs.one", vo);
		System.out.println("-----------------" + vo2);
		return vo2;
	}
	
	public List<BbsVO> list() {
		// 업캐스팅하여 사용
		List<BbsVO> list = mybatis.selectList("bbs.list");
		return list;
	}
	
}