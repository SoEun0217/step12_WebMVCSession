package kosta.mvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.LoginDTO;
import kosta.mvc.model.exception.MyErrorException;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private List<LoginDTO> list;
	
	@Override
	public LoginDTO login(String id, String pwd)throws MyErrorException {
		for(LoginDTO l:list) {
			if(l.getId().equals(id)&&l.getPwd().equals(pwd)) {
				return l;
			}
		}
		return null;
	}

}
