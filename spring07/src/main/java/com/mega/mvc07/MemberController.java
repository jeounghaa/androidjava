package com.mega.mvc07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("list2.do")
	public void list(Model model) {
		List<MemberVO> list = service.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("one2.do")
	public void one(MemberVO memberVO, Model model) {
		MemberVO vo = service.one(memberVO);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("create2.do")
	public void create(MemberVO memberVO) {
		service.insert(memberVO);
	}
	
	@RequestMapping("update2.do")
	public void update(MemberVO memberVO) {
		service.update(memberVO);
	}
	
	@RequestMapping("delete2.do")
	public void delete(MemberVO memberVO) {
		service.delete(memberVO);
	}
	
}
