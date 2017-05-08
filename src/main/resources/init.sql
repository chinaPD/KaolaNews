create table user_ (
  username_ varchar(20) unique not null,
  password_ varchar(20) not null,
  id_ int unsigned auto_increment,
  nickname_ varchar(20) not null,
  primary key(id_)
);

CREATE TABLE articles_ (
  id int unsigned auto_increment,
  author nvarchar(20),
  titile nvarchar(200),
  summary nvarchar(500),
  typelabel nvarchar(20),
  addtime datetime,
  updatetime datetime,

  uri varchar(200),

  PRIMARY KEY (id)
);

insert into user_ (username_, password_, nickname_) values ('admin', 'password', 'admin' );
insert into articles_(author, titile, summary, uri) values
('panda', '最多n次购买时股票最大收益问题', '最多n次购买时股票最大收益问题', 'http://www.jianshu.com/p/020f69c53154');

insert into articles_(author, titile, summary,typelabel, uri) values
('panda', '最多n次购买时股票最大收益问题', '最多n次购买时股票最大收益问题', 'algorithm','http://www.jianshu.com/p/020f69c53154'),
('panda', 'java nio', 'java nio ', 'algorithm','http://www.jianshu.com/p/020f69c53154'),
('shang', 'war nio', 'war  nio ', 'war','http://www.jianshu.com/p/020f69c53154'),
('laowang', 'killed', 'killed', 'war','http://www.jianshu.com/p/020f69c53154'),
('李某', '狙击枪教程', '狙击枪教程', 'war','http://www.jianshu.com/p/020f69c53154'),
('panda', 'KMP算法应用', 'KMP算法应用', 'algorithm','http://www.jianshu.com/p/020f69c53154');
