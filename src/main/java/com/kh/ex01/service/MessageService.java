package com.kh.ex01.service;

import com.kh.ex01.vo.MessageVo;
import com.kh.ex01.vo.PointVo;

public interface MessageService {
	public boolean sendMessage(MessageVo messageVo);
	public MessageVo readMessage(int mid, PointVo pointVo);
}
