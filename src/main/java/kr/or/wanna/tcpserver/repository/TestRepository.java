package kr.or.wanna.tcpserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.or.wanna.tcpserver.vo.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
	
}
