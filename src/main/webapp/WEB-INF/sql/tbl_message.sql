create table tbl_message (
	mid number primary key, -- 메세지 번호
	sender varchar2(50) references tbl_member(userid), -- 보낸 사람
	receiver varchar2(50) references tbl_member(userid), -- 받는 사람
	message varchar2(500) not null, -- 메세지 내용
	sendate date default sysdate, -- 보낸 날짜
	opendate date 
);

-- 포인트 컬럼 추가
alter table tbl_member
add m_point number default 0;