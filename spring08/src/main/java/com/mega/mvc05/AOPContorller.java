package com.mega.mvc05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOPContorller implements AOPinterface {
	
	@Autowired
	ASite a;
	
	@Autowired
	BSite b;
	
	/* (non-Javadoc)
	 * @see com.mega.mvc05.AOPinterface#aop1()
	 */
	@Override
	@RequestMapping("a.do")
	public void aop1() {
		a.person();
	}
	
	/* (non-Javadoc)
	 * @see com.mega.mvc05.AOPinterface#aop2()
	 */
	@Override
	@RequestMapping("b.do")
	public void aop2() {
		b.search();
		b.bucket();
		b.jumun();
	}
	
}
