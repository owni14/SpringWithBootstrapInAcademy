package com.kh.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ex01.dao.MemberDao;
import com.kh.ex01.vo.MemberVo;
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void insertMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVo> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo getMemberById(String userid) {
		MemberVo memberVo = memberDao.getMemberById(userid);
		return memberVo;
	}

	@Override
	public boolean modifyMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMember(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

}
