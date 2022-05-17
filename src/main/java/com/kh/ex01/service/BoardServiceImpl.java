package com.kh.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ex01.dao.BoardDao;
import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean create(BoardVo boardVo) {
		boolean result = boardDao.create(boardVo);
		return result;
	}

	@Override
	public BoardVo read(int bno) {
		BoardVo boardVo = boardDao.read(bno);
		return boardVo;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		boolean result = boardDao.update(boardVo);
		return result;
	}

	@Override
	public boolean delete(int bno) {
		boolean result = boardDao.delete(bno);
		return result;
	}

	@Override
	public List<BoardVo> list(PagingDto pagingDto) {
		List<BoardVo> list = boardDao.list(pagingDto);
		return list;
	}

	@Override
	public int getCount() {
		int count = boardDao.getCount();
		return count;
	}

}
