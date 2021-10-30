package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

//使用 @Service 註釋實現 ProductService 接口，並編寫業務邏輯來
//存儲、檢索、刪除和更新產品。
@Service
public class ProductServiceImpl implements ProductService {
	private static Map<String, Product> ProductRepo = new HashMap<String, Product>();
	
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		ProductRepo.put(honey.getId(),honey);
		
		Product almond = new Product();//杏仁
		almond.setId("2");
		almond.setName("Almond");
		ProductRepo.put(almond.getId(),almond);
	}
	
	@Override
	public void createProduct(Product product) {
		ProductRepo.put(product.getId(), product);

	}

	@Override
	public void updateProduct(String id, Product product) {
		ProductRepo.remove(id);
		product.setId(id);
		ProductRepo.put(id, product);

	}

	@Override
	public void deleteProduct(String id) {
		ProductRepo.remove(id);

	}

	@Override
	public Collection<Product> getProducts() {
		
		return ProductRepo.values();
	}

}
