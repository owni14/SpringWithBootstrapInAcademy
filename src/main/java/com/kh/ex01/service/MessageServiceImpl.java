package com.kh.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.ex01.dao.MessageDao;
import com.kh.ex01.dao.Pointdao;
import com.kh.ex01.vo.MessageVo;
import com.kh.ex01.vo.PointVo;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private Pointdao pointDao;
	
	@Override
	@Transactional
	public boolean sendMessage(MessageVo messageVo) {
		boolean result1 = messageDao.insertMessage(messageVo);
		PointVo pointVo = new PointVo(messageVo.getSender(), Pointdao.SEND_MESSAGE_POINT, Pointdao.SEND_MESSAGE_CODE);
		boolean result2 = pointDao.updatePoint(pointVo);
		boolean result3 = pointDao.insertPoint(pointVo);
		if (result1 && result2 && result3) {
			return true;
		}
		return false;
	}

	@Override
	public MessageVo readMessage(int mid, PointVo pointVo) {
		// tbl_message : opendate - update
		boolean result1 = messageDao.updateOpenDate(mid);
		// tbl_member : point - update
		boolean result2 = pointDao.updatePoint(pointVo);
		// tbl_point : insert
		boolean result3 = pointDao.insertPoint(pointVo);
		if (result1 && result2 && result3) {
			MessageVo messageVo = messageDao.readMessage(mid);
			return messageVo;
		}
		return null;
	}

	@Override
	public List<MessageVo> listMessage(String userid, String mType) {
		List<MessageVo> messageList = messageDao.listMessage(userid, mType);
		return messageList;
	}

}
