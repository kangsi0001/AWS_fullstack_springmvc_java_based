package com.cordkang.mapper;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cordkang.service.SampleService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {
	@Autowired
	private SampleService service;
	
	@Test
	public void testExist(){
		assertNotNull(service);
	}
	
	@Test
	public void testAddData() {
		String data = " 4인승 SUV인 GV80쿠페 콘셉트는 다양한 라이프스타일을 염두에 둔 실용성과 스포티함이 결합된 모델이다. ";
		//제네시스는 ‘역동적인 우아함(Athletic Elegance)’ 이라는 디자인 철학을 기반으로 상반된 요소들의 완벽한 조화를 통해 성능이 뛰어나면서도 감성적인 차량을 개발하겠다는 의지를 이번 콘셉트에 담았다
//	  byte[] bs =  data.getBytes("utf-8");
//	  log.info(bs.length);
//	  byte[] bs2 = new byte[50];
//	  System.arraycopy((bs, 0, bs2, 0, 50);
		//data = "abcd";
	  // log.info(data.length);
	  
	  service.addData(data);
	}

}
