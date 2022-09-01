package com.springboot.jpa.data.dao.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.el.ELException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;

@Component // 클래스를 빈으로 등록하기 위해 어노테이션 지정
// 빈으로 등록된 객체는 다른 클래스가 인터페이스를 가지고 의존성 주입받을 때 이 구현체를 찾음
public class ProductDAOImpl implements ProductDAO{ 
  // 리포지토리 정의
  private final ProductRepository productRepository;

  // 생성자를 통해 의존성 주입
  @Autowired
  public ProductDAOImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product insertProduct(Product product) {
    // 리포지토리를 생성할 때 인터페이스에서 따로 메서드를 구현하지 않아도 JPA 기본 메서드 save 활용가능
    Product svaedProduct = productRepository.save(product); 
    return svaedProduct;
  }

  @Override
  public Product selectProduct(Long number) {
    // Optional<Product> selectProduct = productRepository.findById(number);
    Product selectedProduct = productRepository.getById(number);
    return selectedProduct;
  }

  @Override 
  public Product updateProductName(Long number, String name) throws Exception {
    // update 키워드 X
    Optional<Product> selectedProduct = productRepository.findById(number); // 영속성 컨테스트에 추가됨

    Product updatedProduct; 
    if (selectedProduct.isPresent()) {
      Product product = selectedProduct.get();

      // 값을 변경 후
      product.setName(name);
      product.setUpdatedAt(LocalDateTime.now());

      // save 하면 Dirty Check 
      updatedProduct = productRepository.save(product);
    } else {
      throw new Exception();
    }

    return updatedProduct;
  }

  @Override
  public void deleteProduct(Long number) throws Exception{
    Optional<Product> selectedProduct = productRepository.findById(number);

    if (selectedProduct.isPresent()) {
      Product product = selectedProduct.get();
      productRepository.delete(product);
    } else {
      throw new ELException();
    }
  }
  
}