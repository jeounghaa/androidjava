package com.mega.mvc07;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  
public class MemberDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<MemberVO> list() {
		List<MemberVO> list = mybatis.selectList("member.list");
		System.out.println("list size: " + list.size());
		return list;
	}
	
	public MemberVO one(MemberVO vo) {
		MemberVO vo2 = mybatis.selectOne("member.one", vo);
		             // 네임스페이스이름.id, 입력parameter
		return vo2;
	}

	public int insert(MemberVO vo) {
		int result = mybatis.insert("member.insert", vo);
		System.out.println(result);
		return result;
	}

	public void update(MemberVO vo) {
		mybatis.update("member.update", vo);
	}

	public void delete(MemberVO vo) {
		mybatis.update("member.delete", vo);
	}
	
}
