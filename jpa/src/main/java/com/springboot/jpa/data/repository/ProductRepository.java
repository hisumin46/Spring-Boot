package com.springboot.jpa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.data.entity.Product;

// 접근하려는 테이블과 매핑되는 엔티티에 대한 인터페이스 생성 뒤 - Product
// JpaRepository를 상속 받음
public interface ProductRepository extends JpaRepository<Product, Long>{
  
}
