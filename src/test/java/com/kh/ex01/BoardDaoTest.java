package com.kh.ex01;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.BoardDao;
import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class BoardDaoTest {
	
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void testPagingDto() {
		PagingDto pagingDto = new PagingDto();
		pagingDto.setPerPage(5);
		pagingDto.setPage(3);
		System.out.println("pagingDto:" + pagingDto);
	}
	
	@Test
	public void testInsert500() {
		for (int i = 0; i <= 500; i++) {
			BoardVo boardVo = new BoardVo("제목-"+ i, "내용-" + i, "user01");
			boardDao.create(boardVo);
		}
	}
	
	@Test
	public void testCreate() {
		BoardVo boardVo = new BoardVo("제목-2", "내용-2", "user02");
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
		PagingDto pagingDto = new PagingDto();
		pagingDto.setPage(1);
		List<BoardVo> list = boardDao.list(pagingDto);
		for (BoardVo boardVo : list) {
			System.out.println(boardVo);
		}
	}
}
