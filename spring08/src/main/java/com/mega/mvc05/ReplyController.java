package com.mega.mvc05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {

	@Autowired
	ReplyService service;
	// 의존성 주입(di)를 할 때는 ReplyService클래스의
	// 싱글톤 객체가 있는지 찾아서 그 주소를 주입
	// 클래스의 타입을 가지고 주입

	@RequestMapping("create.do")
	public String create(ReplyVO replyVO) {
		int result = service.create(replyVO);
		if (result == 1) {
			// 답글이 잘 저장이 되었을 경우
			return "ok";
		} else {
			// 답글 저장에 문제가 생길 경우
			return "fail";
		}
	}
	
	@RequestMapping(value="delete3.do", method=RequestMethod.GET) // get일 경우
	public String delete(ReplyVO replyVO) {
		int result = service.delete(replyVO);
		if (result == 1) {
			// response.sendRedirect("one.do?no="+replyVO.getOriginal()); // 밑에와 동일한 코드
			return "redirect:one.do?no=" + replyVO.getOriginal();
		} else {
			return "fail";
		}
	}

}
