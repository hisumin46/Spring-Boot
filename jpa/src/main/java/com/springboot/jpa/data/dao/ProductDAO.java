package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Product;

// 인터페이스 메서드 정의
public interface ProductDAO {
  Product insertProduct(Product product);

  Product selectProduct(Long number);

  Product updateProductName(Long number, String name) throws Exception;

  void deleteProduct(Long number) throws Exception;
}
