package com.mega.mvc02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("insert.do")
	public void insert(String id, String pw) {
		String result = "회원가입 실패";
		if(!(id.isEmpty() && pw.isEmpty())){
			result = "로그인 성공";
		}
		System.out.println(result);
	}
	
}
