package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dao.ProductDAOImpl;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service("service")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<ProductDTO> select() {
		List <ProductDTO> list = dao.select();
		return list;
	}
	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		
		if(productDTO.getPrice()<1000||productDTO.getPrice()>10000) {
			throw new MyErrorException("������ �Է¹����� 1000~10000���̹Ƿ� �ʰ��Ͽ����ϴ�.");
		}
		 dao.insert(productDTO);
		return 1 ;
	}
	@Override
	public int delete(String code) throws MyErrorException {
		dao.delete(code);
		return 1;
	}
	@Override
	public ProductDTO detail(String code) throws MyErrorException {
		ProductDTO dto = dao.searchByCode(code);
		if(dto==null)throw new MyErrorException(code+"������ �߸��Ǿ� �˻��� �� �����ϴ�.");
		return dto;
	}

}
