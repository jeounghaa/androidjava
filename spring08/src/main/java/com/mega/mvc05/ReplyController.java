package com.mega.mvc05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {

	@Autowired
	ReplyService service;
	// 의존성 주입(di)를 할 때는 ReplyService클래스의
	// 싱글톤 객체가 있는지 찾아서 그 주소를 주입
	// 클래스의 타입을 가지고 주입

	@RequestMapping("create.do")
	public void create(ReplyVO replyVO) {
		service.create(replyVO);
	}

}
