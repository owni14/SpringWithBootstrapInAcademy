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