package kr.or.wanna.tcpserver.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.wanna.tcpserver.repository.TestRepository;
import kr.or.wanna.tcpserver.vo.Test;

@Service
public class TestServer {
	private final TestRepository testRepository;
	
	@Autowired
	public TestServer(TestRepository testRepository) {
		this.testRepository = testRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Test> findAll() throws Exception {
		return testRepository.findAll();
	}
}
