-- c##spring
create table tbl_member(     
    userid varchar2(50) primary key,
    userpw varchar2(50) not null,
    username varchar2(50) not null,
    email varchar2(100),
    regdate date default sysdate,
    updatedate date default sysdate
);

-- 포인트 칼럼 추가
alter table tbl_member
add m_point number default 0;

-- 사진 칼럼 추가
alter table tbl_member
add m_pic varchar2(100);