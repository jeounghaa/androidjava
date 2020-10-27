package com.mega.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러 역할
@Controller
public class PageController {
	
	// 요청 당 하나의 메서드 생성
	// 클라이언트에게 page2.mega가 요청되면 메서드가 호출됨
	// 2. 컨트롤러에서 받아주고
	@RequestMapping("page2.mega")
	public void page2(String id, String pw, Model model) {
		System.out.println("이 메서드가 자동 호출됨");
		System.out.println("받은 id: " + id);
		System.out.println("받은 pw: " + pw);
		// 3. DAO객체 서서 DB처리
		String result = "로그인 실패";
		if(id.equals("root") && pw.equals("1234")){
			result = "로그인 성공";
		}
		// 4. 처리 결과를 가지고 jsp페이지로 간다
		model.addAttribute("result", result);
	}
	
}
