package com.kh.ex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	private final String NAMESPACE = "com.kh.ex01.mappers.member.";
	
	@Autowired // @inject
	private SqlSession sqlSession;
	
	@Override
	public String getTime() {
		// mappers/member-mapper.xml - com.kh.ex01.mappers.member.getTime
		String time = sqlSession.selectOne(NAMESPACE + "getTime");
		return time;
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		sqlSession.insert(NAMESPACE + "insertMember", memberVo);
	}

	@Override
	public List<MemberVo> getMemberList() {
		List<MemberVo> memberList = sqlSession.selectList(NAMESPACE + "getMemberList");
		return memberList;
	}

	@Override
	public MemberVo getMemberById(String userid) {
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "getMemberById", userid);
		return memberVo;
	}

	@Override
	public boolean modifyMember(MemberVo memberVo) {
		int count = sqlSession.update(NAMESPACE + "modifyMember", memberVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMember(String userid) {
		int count = sqlSession.delete(NAMESPACE + "deleteMember", userid);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
}
