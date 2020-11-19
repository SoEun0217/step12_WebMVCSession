package kosta.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.LoginDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/login.kosta")
	public ModelAndView login(String id,String pwd,HttpSession session) throws MyErrorException{
		LoginDTO dto = service.login(id, pwd);
		if(dto==null) {
			throw new MyErrorException("�߸��� ���������Դϴ�.");
		}
		session.setAttribute("id", dto.getId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("logni");
		return mv;
	}
	
	@ExceptionHandler(value=MyErrorException.class)
	public ModelAndView exception(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject(e.getMessage());
		return mv;
	}
}