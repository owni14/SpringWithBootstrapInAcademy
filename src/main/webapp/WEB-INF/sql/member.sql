create table tbl_member(     
    userid varchar2(50) primary key,
    userpw varchar2(50) not null,
    username varchar2(50) not null,
    email varchar2(100),
    regdate date default sysdate,
    updatedate date default sysdate
);