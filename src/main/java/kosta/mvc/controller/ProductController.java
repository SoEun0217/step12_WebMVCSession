package kosta.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	/**
	 * ��ü�˻� ��û
	 * */
	@RequestMapping("/index.kosta")
	public ModelAndView select(){
		List <ProductDTO> list = service.select();
		
		return new ModelAndView("productList","list",list);
	}
	
	/**
	 * ��ǰ�����
	 * */
	@RequestMapping("{url}.kosta")
	public void insertForm(HttpSession session)throws MyErrorException {	
		if(session.getAttribute("id")==null) {
			throw new MyErrorException("ȸ���� ���� �����մϴ�.");
		}
	}//��û�� ������ mapping�� �̸��� ���� ��� �̵��Ѵ�.
	
	/**
	 * ��ǰ����ϱ�
	 * */
	@PostMapping("/insert.kosta")
	public String insert(ProductDTO productDTO)throws MyErrorException {
		//post��� �ѱ����ڵ��� web.xml�� ����ó�����ش�.
		//exception�� �ٸ����� ó���ؾ��ϹǷ� �������Ѵ�...
		
		service.insert(productDTO);
		return "redirect:index.kosta";//controller�� �ִ� requestMapping�� ã�´�
	}
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/{code}")
	public String delete(@PathVariable String code)throws MyErrorException {//?code=A01�� ���� ������̼��� ���� �� {}���� ������ parameter��������!
		service.delete(code);
		return "redirect:index.kosta";
	}
	
	@RequestMapping("/read.kosta")
	public ModelAndView detail(String code,HttpSession session)throws MyErrorException {
		if(session.getAttribute("id")==null) {
			throw new MyErrorException("ȸ���� ���ٰ����մϴ�.");
		}
		ProductDTO dto = service.detail(code);
		return new ModelAndView("detailForm", "dto",dto);
	}
	
	
	@ExceptionHandler(value=MyErrorException.class)
	public ModelAndView exception(MyErrorException e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errMessage",e.getMessage());
		return mv;
	}
	
	
	
}
