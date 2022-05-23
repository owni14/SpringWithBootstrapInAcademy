package com.kh.ex01.vo;

import java.sql.Date;

public class MessageVo {
	private int mid;
	private String sender;
	private String receiver;
	private String message;
	private Date senddate;
	private Date opendate;
	
	public MessageVo() {
		super();
	}

	public MessageVo(String sender, String receiver, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	public MessageVo(int mid, String sender, String receiver, String message, Date sendate, Date opendate) {
		super();
		this.mid = mid;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.senddate = sendate;
		this.opendate = opendate;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSendate() {
		return senddate;
	}

	public void setSendate(Date sendate) {
		this.senddate = sendate;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	@Override
	public String toString() {
		return "MessageVo [mid=" + mid + ", sender=" + sender + ", receiver=" + receiver + ", message=" + message
				+ ", sendate=" + senddate + ", opendate=" + opendate + "]";
	}

}
