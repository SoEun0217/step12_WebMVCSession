package kosta.mvc.model.service;

import kosta.mvc.model.dto.LoginDTO;
import kosta.mvc.model.exception.MyErrorException;

public interface LoginService  {
	LoginDTO login (String id,String pwd)throws MyErrorException;
}
