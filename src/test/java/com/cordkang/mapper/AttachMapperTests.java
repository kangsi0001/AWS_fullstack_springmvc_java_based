package com.cordkang.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cordkang.task.FileCheckTask;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AttachMapperTests {
//	private AttachMapper attchMapper;
	@Autowired
	private FileCheckTask task;
	

	@Test
	public void testCheckFiles(){
		task.checkFiles();
	}
}
