package kosta.mvc.model.dao;

import kosta.mvc.model.dto.LoginDTO;
import kosta.mvc.model.exception.MyErrorException;

public interface LoginDAO {
	LoginDTO login (String id,String pwd) throws MyErrorException;
}
