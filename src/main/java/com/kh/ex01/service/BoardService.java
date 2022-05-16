package com.kh.ex01.service;

import java.util.List;

import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

public interface BoardService {
	public boolean create(BoardVo boardVo); // 글쓰기(Create)
	public BoardVo read(int bno); // 글읽기(Read) - 글 1개 읽기
	public boolean update(BoardVo boardVo); // 글수정(Update)
	public boolean delete(int bno); // 글삭제(Delete)
	public List<BoardVo> list(PagingDto pagingDto); // 글목록(Read)
}
