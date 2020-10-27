package com.mega.mvc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

	@Autowired
	MovieService service;

	@RequestMapping("idid.do")
	public String idid(String idid, Model model) {
		

//		String result = "사용 가능";
//		for (int i = 0; i < name.length; i++) {
//			if (idid.equals(name[i])) {
//				result = "중복";
//			}
//			model.addAttribute("result", result);
//		}
		String[] values = service.idCheck(idid);
		model.addAttribute("result", values[0]);
		return values[1];
	}

	@RequestMapping("reply.do")
	public void reply(String reply, Model model) {
		// db처리 했음
		// views로 넘어감
		model.addAttribute("reply", reply);
	}

	@RequestMapping("movie.do")
	public String movie(String title, int price, Model model) {
		System.out.println("title: " + title + ", pay: " + price);
		price = service.price(price);

		model.addAttribute("title", title);
		model.addAttribute("price", price);
		return "like";
	}

}
