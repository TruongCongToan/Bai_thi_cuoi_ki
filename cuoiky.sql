create database quanly;
create table MonHoc
(
MaMH varchar(20) not null,
TenMH varchar(20) not null,
SoTC varchar(20) not null
);   
alter table MonHoc add constraint primary key(MaMH);
create table GiaoVien(
MaGV varchar(20) not null,
HoGV varchar(20) not null,
TenGV varchar(20) not null,
DonVi varchar(20) not null
);
alter table GiaoVien add constraint primary key(MaGV);
create table SinhVien(
MaSV varchar(20) not null,
HoSV varchar(20) not null,
TenSV varchar(20) not null,
NgaySinh varchar(15) not null,
NoiSinh varchar(20) not null
);
alter table SinhVien add constraint primary key(MaSV);

create table Lop(
MaLop varchar(20) not null,
MaMH varchar(20) not null,
NamHoc varchar(20) not null,
HocKy varchar(20) not null, 
MaGV varchar(20) not null,
primary key(MaLop),
foreign key(MaMH) references MonHoc(MaMH) on delete cascade,
foreign key(MaGV) references GiaoVien(MaGV) on delete cascade
);
create table SinhVienLop
(
MaSV varchar(20) not null,
MaLop varchar(20) not null,
Diem double not null,
primary key (MaSV,MaLop),
foreign key(MaSV) references SinhVien(MaSV) on delete cascade,
foreign key(MaLop) references Lop(MaLop) on delete cascade
);
alter table Lop add foreign key(MaMH) references MonHoc(MaMH) on update cascade;
alter table Lop add foreign key(MaGV) references GiaoVien(MaGV) on update cascade;

alter table SinhVienLop add foreign key(MaSV) references SinhVien(MaSV) on update cascade;
alter table SinhVienLop add foreign key(MaLop) references Lop(MaLop) on update cascade;

alter table Lop modify column Diem double not null;

//lenh tao user moi
create user 'username'@'localhost' identified by 'password';
grant all on dbname.* to username@localhost;
FLUSH PRIVILEGES;

ALTER TABLE tbl_name ADD UNIQUE index_name (column_list);//create index;
ALTER TABLE tblUsers ADD INDEX (c);
ALTER TABLE tblUsers DROP INDEX (c);
//tao trigger
create trigger nameoftrigger on nameoftable for insert as if 	(select *from inserted where age<16) println("Tuoi khong the nho hon 16");
