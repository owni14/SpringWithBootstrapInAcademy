package com.kh.ex01.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.MemberVo;

@Repository("impl2")
public class MemberDaoImpl2 implements MemberDao{

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return null;
	}

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
		// TODO Auto-generated method stub
		return null;
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
