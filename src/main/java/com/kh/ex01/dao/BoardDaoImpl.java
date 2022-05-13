package com.kh.ex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao{
	private final String NAMESPACE = "com.kh.ex01.mappers.board.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean create(BoardVo boardVo) {
		int count = sqlSession.insert(NAMESPACE + "create", boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public BoardVo read(int bno) {
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE + "read", bno);
		return boardVo;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		int count = sqlSession.update(NAMESPACE + "update", boardVo);
		if (count > 0 ) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int bno) {
		int count = sqlSession.delete(NAMESPACE + "delete", bno);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<BoardVo> list() {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + "list");
		return list;
	}

}
