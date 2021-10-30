package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

//@RestController 註釋用於定義 RESTful Web 服務。它提供 JSON、XML 和自定義響應。
@RestController
public class ProductServiceController {
	@Autowired
	ProductService productService;
	
//	@Bean
//	public ProductServiceImpl getProductServiceImpl() {
//		return new ProductServiceImpl();
//	}
//	
	
//	GET api
	@RequestMapping(value="/products")
	@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<Object> getProduct(){
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}
	
	//@RequestParam 註解用於從請求 URL 中讀取請求參數。預設情況下，它是必需參數。我們還可以為請求參數設置默認值
//	@RequestMapping(value="/products")
//	public ResponseEntity<Object> getProduct(@RequestParam(value = "name", required = false, defaultValue = "honey") String name) {
//		return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
	      productService.createProduct(product);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }
	
	//@RequestMapping在class內外也可以，可在class層面上配合@GetMapping 使用
	//@RequestMapping 註釋用於定義請求 URI 以訪問 REST 端點。我們可以定義 Request 方法來消費和生產對象。預設的請求方法是 GET。
	//@PathVariable 註釋用於定義自定義或動態請求 URI。請求 URI 中的 Path 變量定義為花括號 {}
	//	delete api
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product is deleted successfully",HttpStatus.OK);
	}
	
	//@RequestBody 註解用於定義請求html body裡from表單的正文內容類型。
	//	put api
	@RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,@RequestBody Product product){
		//例外處理:在更新產品時，如果沒有找到產品，則由ProductExceptionController返迴響應錯誤訊息"Product not found"。
//		if(!productRepo.containsKey(id)) throw new ProductNotfoundException();

		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product is updated successfully",HttpStatus.OK);
	}

	
}
