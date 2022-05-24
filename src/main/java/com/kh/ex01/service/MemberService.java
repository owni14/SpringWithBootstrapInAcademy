package com.kh.ex01.service;

import java.util.List;

import com.kh.ex01.vo.MemberVo;

public interface MemberService {
	public void insertMember(MemberVo memberVo); // 회원 추가
	public List<MemberVo> getMemberList(); // 회원 목록
	public MemberVo getMemberById(String userid); // 아이디 조회
	public boolean modifyMember(MemberVo memberVo); // 회원 수정
	public boolean deleteMember(String userid); // 회원 삭제
}
