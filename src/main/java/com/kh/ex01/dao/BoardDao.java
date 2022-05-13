package com.kh.ex01.dao;

import java.util.List;

import com.kh.ex01.vo.BoardVo;

public interface BoardDao {
	public boolean create(BoardVo boardVo); // 글쓰기(Create)
	public BoardVo read(int bno); // 글읽기(Read) - 글 1개 읽기
	public boolean update(BoardVo boardVo); // 글수정(Update)
	public boolean delete(int bno); // 글삭제(Delete)
	public List<BoardVo> list(); // 글목록(Read)
}