package kr.inhatc.spring.sumin_shop.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.sumin_shop.test.entity.Test;

// Entity에 의해 생성된 DB에 접근하는 메서드(ex) findAll()) 들을 사용하기 위한 인터페이스
// 여기에 어떤 값을 넣거나, 넣어진 값을 조회하는 등의 CRUD 기능을 정의
// JpaRepository<대상으로 지정할 엔티티, 해당 엔티티의 PK의 타입>.
public interface TestRepository extends JpaRepository<Test, Long>{
  
}
