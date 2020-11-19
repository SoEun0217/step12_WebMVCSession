package kosta.mvc.model.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Repository //id="productDAOImpl"
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private List <ProductDTO>list;
		
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//�ߺ�üũ����..
		if(this.searchByCode(productDTO.getCode())!=null) {
			throw new MyErrorException(productDTO.getCode()+"�ڵ�� �ߺ��Դϴ�.");
		}
		
		list.add(productDTO);
		return 1;
		
	}

	@Override
	public int delete(String code) throws MyErrorException {
		ProductDTO dto = this.searchByCode(code);
		if(dto==null) {
			throw new MyErrorException(code+"�� �ش��ϴ� ������ ã�� �� �����ϴ�.");
		}
		list.remove(dto);
		return 1;
	}
	
	/**
	 * ��ǰ�ڵ忡 �ش��ϴ� ��ǰ���� ��������
	 * */
	@Override
	public ProductDTO searchByCode(String code) throws MyErrorException {
		for(ProductDTO dto:list) {
			if(dto.getCode().equals(code)) {
				return dto;
			}
		}
		return null;//������ null����..
	}
	

}
