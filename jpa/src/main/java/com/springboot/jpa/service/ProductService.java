package com.springboot.jpa.service;

import com.springboot.jpa.dto.ProductDto;
import com.springboot.jpa.dto.ProductResponseDto;

public interface ProductService {
  ProductResponseDto getProduct(Long number);

  ProductResponseDto saveProduct(ProductDto productdto);

  ProductResponseDto changeProductName(Long number, String name) throws Exception;

  void deleteProduct(Long number) throws Exception;
}
