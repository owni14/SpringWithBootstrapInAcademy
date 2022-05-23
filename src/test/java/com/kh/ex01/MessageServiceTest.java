package com.kh.ex01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.Pointdao;
import com.kh.ex01.service.MessageService;
import com.kh.ex01.vo.MessageVo;
import com.kh.ex01.vo.PointVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MessageServiceTest {
	@Autowired
	private MessageService messageService;
	
	@Test
	public void testSendMessage() {
		MessageVo messageVo = new MessageVo("user01", "user02", "Hello");
		boolean result = messageService.sendMessage(messageVo);
		System.out.println("result :" + result);
	}
	
	@Test
	public void testReadMessage() {
		int mid = 33; // user01 -> user02 - Hello라고 보냄
		PointVo pointVo = new PointVo();
		pointVo.setUserid("user02");
		pointVo.setPoint(Pointdao.READ_MESSAGE_POINT);
		pointVo.setPcode(Pointdao.READ_MESSAGE_CODE);
		MessageVo messageVo = messageService.readMessage(mid, pointVo);
		System.out.println("messageVo:" + messageVo);
	}
}
