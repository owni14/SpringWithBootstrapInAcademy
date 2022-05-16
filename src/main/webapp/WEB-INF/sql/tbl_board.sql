-- c##spring
create table tbl_board(
    bno number primary key,
    title varchar2(100) not null,
    content varchar2(4000),
    writer varchar2(50) not null,
    regdate date default sysdate,
    viewcnt number default 0
);

-- 글번호용 시퀀스
create sequence seq_board_bno;

-- 데이터 전체 삭제 --
truncate table tbl_board;

-- 시퀀스 새로 생성 --
drop sequence seq_board_bno;
create sequence seq_board_bno;