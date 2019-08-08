-- localhost 에서만 접속 할 수 있는 계정 생성
create user 'num'@localhost identified by 'gncngncn11';

-- 어디서든 접속 가능한 계정 생성
create user 'num'@'%' identified by 'gncngncn11';

-- 유저 삭제
delete from user where user='num';

-- 유저에게 특정 database에 접속 할 수 있는 권한 주기
grant all privileges on board.* to 'num'@'localhost' identified by 'gncngncn11' with grant option;

-- 권한 확인하기
show grants for 'num'@'%';

-- 권한 해지하기
revoke all on information_schema.* from 'num'@'localhost';


---------------------------- 인코딩 관련 내용
-- Database 만들기
CREATE DATABASE db명 DEFAULT CHARACTER SET UTF8; 

-- 이미 데이터베이스를 만들었을 경우 인코딩을 변경 방법
-- Database 인코딩 변경
ALTER DATABASE db명 DEFAULT CHARACTER SET utf8;

-- 테이블도 인코딩 변경
use board;
ALTER TABLE t_board CONVERT TO charset utf8;

-- 데이터베이스에 인코딩 확인하는 방법
select schema_name, default_character_set_name from information_schema.schemata;

------------------- mysql 전체 설정
-- 사용할 수 있는 케릭터 셋 확인 방법
show variables like 'char%';

-- 현재 적용된 케릭터 셋 확인 방법
status;
-- 또는 
\s

-- 각 부분별 character set 설정 방법
-- my.ini 또는 my.cnf 파일 위치 찾기
SHOW VARIABLES WHERE Variable_Name LIKE "%dir";
-- datadir 값에 Data 폴더 상위에 존재

[client]
default-character-set=utf8

[mysqld]
collation-server = utf8_unicode_ci
character-set-server = utf8
skip-character-set-client-handshake

[mysql]
default-character-set=utf8

[mysqldump]
default-character-set=utf8
---------------------------