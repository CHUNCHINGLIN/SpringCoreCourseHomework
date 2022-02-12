-- 建立Emp資料庫
create table if not exists emp(
eid int not null auto_increment,
ename varchar(50) not null unique,
age int,
createtime timestamp default current_timestamp,
primary key(eid)
);

--建立job
--一員工對應多工作
create table if not exists job(
jid int not null auto_increment,--主鍵
jname varchar(50) not null unique,--工作名稱
eid int,--員工id
primary key(jid),
foreign key(eid) references emp(eid)

);