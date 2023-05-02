package com.cordkang.mapper;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cordkang.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes=RootConfig.class)
@Log4j
public class TimeMapperTests {
	@Autowired
  private TimeMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info(mapper.getTime());
	}
	

//   @Autowired
//   @Resource
//     @Inject 
//	public void setTimeMapper(TimeMapper timeMapper) {
//		this.timeMapper = timeMapper;
//	}
//
//
//
//@Test
//  public void testGetTime(){
//	  log.info(timeMapper);
//	  log.info(timeMapper.getTime());
//  }
//@Test
//public void testGetTime2(){
//	  log.info(timeMapper);
//	  log.info(timeMapper.getTime2());
//}
//@Test
//public void testmemberList(){
//	   timeMapper.memberList().forEach(log::info);
//}

}
