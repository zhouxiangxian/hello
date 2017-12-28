--删除数据库
--创建数据库
--使用数据库
--删除数据表
--创建数据表
--增加测试数据
DROP DATABASE IF EXISTS znt2;
CREATE DATABASE znt2;
USE znt2;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS notice;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS type;
DROP TABLE IF EXISTS user;
CREATE TABLE admin(
     adminid     VARCHAR(200) ,
     password    VARCHAR(32) NOT NULL,
     CONSTRAINT pk_adminid   PRIMARY KEY(adminid)
);
CREATE TABLE notice(
     nid      INT   AUTO_INCREMENT,
     title    VARCHAR(50) NOT NULL,
     content  TEXT,
     pubtime  DATETIME,
     CONSTRAINT pk_nid   PRIMARY KEY(nid)
);
CREATE TABLE user(
     userid    VARCHAR(200) ,
     password  VARCHAR(32),
     points    INT   DEFAULT 0,
     registeredtime    DATETIME ,
     sex       VARCHAR(10)  CHECK( sex IN ('男','女')),
     email     VARCHAR(50),
     image     VARCHAR(200),
     CONSTRAINT pk_userid   PRIMARY KEY(userid)
);
CREATE TABLE type(
     tid    INT  AUTO_INCREMENT,
     title   VARCHAR(200)  NOT NULL,
     description   TEXT,
     CONSTRAINT pk_tid   PRIMARY KEY(tid)
);
CREATE TABLE question(
    qid    INT   AUTO_INCREMENT,
    tid    INT,
    userid     VARCHAR(200),
    aid    INT,
    title     VARCHAR(200)  NOT NULL,
    pubtime   DATETIME  NOT NULL,
    status   INT,
    points   INT,
    count    INT  DEFAULT  0,
    content  TEXT,
    CONSTRAINT   pk_qid   PRIMARY KEY(qid),
    CONSTRAINT   fk_tid   FOREIGN KEY(tid) REFERENCES  type(tid)   ON DELETE CASCADE,
    CONSTRAINT   fk_userid FOREIGN KEY(userid)  REFERENCES  user(userid)  ON DELETE CASCADE
);
CREATE TABLE  answer(
     aid    INT AUTO_INCREMENT,
     qid    INT  ,
     userid   VARCHAR(200),
     content   TEXT,
     retdate   DATETIME,
     CONSTRAINT  pk_aid   PRIMARY KEY(aid),
     CONSTRAINT  fk_qid   FOREIGN KEY(qid)  REFERENCES  question(qid)   ON DELETE  CASCADE,
     CONSTRAINT  fk_userid2  FOREIGN KEY(userid)   REFERENCES  user(userid) ON DELETE CASCADE
);
ALTER TABLE question ADD CONSTRAINT fk_aid  FOREIGN KEY(aid)  REFERENCES answer(aid)  ON DELETE CASCADE;

INSERT INTO user (userid,password,points,registeredtime,sex,email,image) VALUES 
	('guest','084E0343A0486FF05530DF6C705C8BB4',0,now(),'男','mldnkf@163.com','nophoto.jpg') ;

INSERT INTO user (userid,password,points,registeredtime,sex,email,image) VALUES 
	('xiaoxian','E95E6121F81893CACDA9580232979452',0,now(),'男','xiaoxian@163.com','nophoto.jpg') ;
INSERT INTO admin(adminid,password)VALUES('admin','21232F297A57A5A743894A0E4A801FC3');
INSERT INTO admin(adminid,password)VALUES('xiaoxian','E95E6121F81893CACDA9580232979452');

INSERT INTO type (title,description) VALUES ('Java SE','面向对象、io、多线程、网络') ;
INSERT INTO type (title,description) VALUES ('Java EE','JSP、Servlet、XML、AJAX') ;
INSERT INTO type (title,description) VALUES ('框架','Struts、Spring、Hibernate、JQuery、EXTJs、JSON') ;
INSERT INTO type (title,description) VALUES ('分布式','EJB、WebServices') ;
INSERT INTO type (title,description) VALUES ('中间件','WebLogic、Websphere、JBoss、Tomcat') ;
INSERT INTO type (title,description) VALUES ('android','Service、Intent、ContentProvider') ;

