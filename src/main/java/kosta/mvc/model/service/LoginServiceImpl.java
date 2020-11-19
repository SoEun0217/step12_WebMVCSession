package kosta.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.LoginDAO;
import kosta.mvc.model.dto.LoginDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO dao;
	
	@Override
	public LoginDTO login(String id, String pwd) throws MyErrorException{
		return dao.login(id, pwd);
	}

}
