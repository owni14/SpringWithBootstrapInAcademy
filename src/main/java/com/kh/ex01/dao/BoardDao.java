package com.kh.ex01.dao;

import java.util.List;

import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

public interface BoardDao {
	public boolean create(BoardVo boardVo); // 글쓰기(Create)
	public BoardVo read(int bno); // 글읽기(Read) - 글 1개 읽기
	public boolean update(BoardVo boardVo); // 글수정(Update)
	public boolean delete(int bno); // 글삭제(Delete)
	public List<BoardVo> list(PagingDto pagingDto); // 글목록(Read)
	public int getCount(PagingDto pagingDto); // 전체 게시글의 수 구하기
	public boolean insertReply(BoardVo boardVo); // 답글쓰기
	public void updateReSeq(BoardVo boardVo); // 답글 순서 조정
}
