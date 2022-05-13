package com.kh.ex01;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.BoardDao;
import com.kh.ex01.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class BoardDaoTest {
	
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void testCreate() {
		BoardVo boardVo = new BoardVo("제목-2", null, "user01");
		boolean result = boardDao.create(boardVo);
		System.out.println("result:" + result);
	}
	
	@Test
	public void testRead() {
		int bno = 1;
		BoardVo boardVo = boardDao.read(bno);
		System.out.println("boardVo:" + boardVo);
	}
	
	@Test
	public void testUpdate() {
		BoardVo boardVo = new BoardVo("제목1-수정", null, "user02");
		boardVo.setBno(1);
		boolean result = boardDao.update(boardVo);
		System.out.println("result:" + result);
	}
	
	@Test
	public void testDelete() {
		int bno = 1;
		boolean result = boardDao.delete(bno);
		System.out.println("result:" + result);
	}
	
	@Test
	public void testList() {
		List<BoardVo> list = boardDao.list();
		for (BoardVo boardVo : list) {
			System.out.println(boardVo);
		}
	}
}
