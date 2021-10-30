package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Product;

public interface ProductService {
	//新增（Create），讀取（Read），更新（Update），刪除（Delete）
	//通常會被簡寫為CRUD
	public abstract void createProduct(Product product);
	public abstract void updateProduct(String id,Product product);
	public abstract void deleteProduct(String id);
	public abstract Collection<Product> getProducts();
}
