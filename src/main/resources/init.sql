-- user info table creation
create table user (
  username varchar(20) unique not null,
  password varchar(20) not null,
  id int unsigned auto_increment,
  nickname varchar(20) not null,
  primary key(id),
  INDEX user_name_index USING BTREE (username),
  INDEX id_index USING BTREE (id)
)ENGINE=InnoDB;



-- article repository creation
CREATE TABLE article (
  id int unsigned auto_increment,
  author nvarchar(20),
  ti2tle nvarchar(200) not null,
  summary nvarchar(500),
  typelabel nvarchar(20),
  addtime datetime,
  updatetime datetime,

  uri varchar(200) not null,

  PRIMARY KEY (id),
  INDEX id_index USING BTREE (id)

) ENGINE=InnoDB;

--  User Collection table creation
CREATE TABLE collection (
  userId int unsigned not null,
  articleId int unsigned not null,
  addtime datetime,

  PRIMARY KEY (userId, articleId),
  FOREIGN KEY (userId) REFERENCES user(id),
  FOREIGN KEY (articleId) REFERENCES article(id),
  INDEX user_id_index USING BTREE (userId)
)ENGINE=InnoDB;

-- ALTER TABLE collection_ ADD INDEX user_id_index BTREE userId;

-- feedback talbe creation
CREATE TABLE feedback (
  id int unsigned auto_increment,
  userId int unsigned,
  errortype nvarchar(10),
  content nvarchar(500),
  contact varchar(50),

  PRIMARY KEY (id),
  INDEX error_type_index USING BTREE (error_type)

);

ALTER TABLE feedback CHANGE COLUMN error_type errortype nvarchar(10);

/* contact could be telephone number or email or others*/
-- ALTER TABLE feedback_ ADD INDEX error_type_index BTREE error_type;


insert into user (username, password, nickname) values ('admin', 'password', 'admin' ),
('guest', 'guest', 'guest'),
('panda', 'panda', 'panda');

insert into articles_(author, titile, summary, uri) values
('panda', '最多n次购买时股票最大收益问题', '最多n次购买时股票最大收益问题', 'http://www.jianshu.com/p/020f69c53154');

insert into article(author, titile, summary,typelabel, uri) values
('panda', '最多n次购买时股票最大收益问题', '最多n次购买时股票最大收益问题', 'algorithm','http://www.jianshu.com/p/020f69c53154'),
('panda', 'java nio', 'java nio ', 'algorithm','http://www.jianshu.com/p/020f69c53154'),
('shang', 'war nio', 'war  nio ', 'war','http://www.jianshu.com/p/020f69c53154'),
('laowang', 'killed', 'killed', 'war','http://www.jianshu.com/p/020f69c53154'),
('李某', '狙击枪教程', '狙击枪教程', 'war','http://www.jianshu.com/p/020f69c53154'),
('panda', 'KMP算法应用', 'KMP算法应用', 'algorithm','http://www.jianshu.com/p/020f69c53154');
