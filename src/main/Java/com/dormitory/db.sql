DROP TABLE IF EXISTS students;

create table students (id bigint primary key auto_increment ,
username varchar(8) unique,
name varchar(8) ,
password varchar(8),
sex char(1),
flatnum varchar(8),
dormnum varchar(8),
telephone varchar(20),
email varchar(32)
);

insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("王八","王八","123","男","公寓楼A座","808室","18796778025","wangba@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("田七","田七","123","男","公寓楼A座","808室","18051186770","tianji@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("夏九","夏九","123","男","公寓楼A座","808室","18994643624","wangba@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("全十","全十","123","男","公寓楼A座","808室","15150510002","quanbao@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("王一","王家辉","123","男","公寓楼B座","413室","18051186770","wangjiahui@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("赵二","赵嗣宇","123","男","公寓楼B座","412室","15150510002","siyu@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("李三","李朋辉","123","男","公寓楼B座","413室","15150510002","lipenghui@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("张四","张志欢","123","男","公寓楼B座","410室","15150510002","zhangzhihuan@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("高五","高少军","123","男","公寓楼B座","409室","15150510002","gaoshaojun@sina.com");
insert into students(username,name,password,sex,flatnum,dormnum,telephone,email) values("庞六","庞博","123","男","公寓楼B座","409室","15150510002","pangbo@sina.com");

DROP TABLE IF EXISTS repairers;

create table repairers (id int primary key auto_increment,
username varchar(8) unique,
name varchar(8) ,
password varchar(8),
sex char(1),
repairer_type varchar(2),
officenum varchar(20),
telephone varchar(20),
email varchar(20),
state varchar(2)
);

insert into repairers(username,name,password,sex,repairer_type,officenum,telephone,email,state) values("刘师傅","刘师傅","123","男","火工","A座201室","0523-87436546","liushifu@sina.com","上班");
insert into repairers(username,name,password,sex,repairer_type,officenum,telephone,email,state) values("李师傅","李师傅","123","男","火工","A座201室","0523-87436546","lishifu@sina.com","下班");
insert into repairers(username,name,password,sex,repairer_type,officenum,telephone,email,state) values("陈师傅","陈师傅","123","男","水工","A座201室","0523-87436546","chenshifu@sina.com","下班");
insert into repairers(username,name,password,sex,repairer_type,officenum,telephone,email,state) values("小迟师傅","小迟师傅","123","男","水工","A座201室","0523-87436546","xiaochi@sina.com","上班");
insert into repairers(username,name,password,sex,repairer_type,officenum,telephone,email,state) values("赵师傅","赵师傅","123","男","电工","A座201室","0523-87436546","zhaoshifu@sina.com","上班");
insert into repairers(username,name,password,sex,repairer_type,officenum,telephone,email,state) values("王师傅","王师傅","123","男","电工","A座201室","0523-87436546","xiao王@sina.com","下班");


DROP TABLE IF EXISTS supervisors;

create table supervisors (id int primary key auto_increment,
username varchar(8) unique,
name varchar(8) ,
password varchar(8),
sex char(1),
officenum varchar(20),
telephone varchar(20),
email varchar(20)
);
insert into supervisors(username,name,password,sex,officenum,telephone,email) values("蔡阿姨","蔡阿姨","123","女","公寓楼2号101室","0523-87436546","caiayi@sina.com");
insert into supervisors(username,name,password,sex,officenum,telephone,email) values("许阿姨","许阿姨","123","女","公寓楼2号101室","0523-87436546","xuayi@sina.com");

DROP TABLE IF EXISTS super_administrators;

create table super_administrators (id int primary key auto_increment,
username varchar(8) unique,
name varchar(8) ,
password varchar(8),
officenum varchar(20),
telephone varchar(20),
email varchar(20)
);

insert into super_administrators(username,name,password,officenum,telephone,email) values("张菲菲","张菲菲","123","主E401室","0523-87436546","zhangfeifei@sina.com");
insert into super_administrators(username,name,password,officenum,telephone,email) values("赵瑾","赵瑾","123","主E401室","0523-87436546","zhaojin@sina.com");



DROP TABLE IF EXISTS items;

create table items (id int not null primary key auto_increment,
name varchar(8),
repertory int,
price varchar(8)
);

insert into items(name,repertory,price) values("水龙头",10,"¥10.0");
insert into items(name,repertory,price) values("喷头",10,"¥10.0");
insert into items(name,repertory,price) values("门锁",20,"¥20.0");
insert into items(name,repertory,price) values("灯泡",20,"¥5.0");
insert into items(name,repertory,price) values("橡胶圈",20,"¥0.5");
insert into items(name,repertory,price) values("座椅",20,"¥50.0");
insert into items(name,repertory,price) values("窗帘",20,"¥60.0");
insert into items(name,repertory,price) values("风扇",10,"¥60.0");
insert into items(name,repertory,price) values("窗帘杆",20,"¥10.0");
insert into items(name,repertory,price) values("地漏",10,"¥5.0");

DROP TABLE IF EXISTS maintenances;

create table maintenances (id int not null primary key auto_increment,
student_id int,
supervisor_id int,
repairer_id int,
repairer_type varchar(2),
fault_type varchar(20),
fault_location varchar(20),
fault_detail varchar(60),
fault_analysis varchar(60),
fault_state varchar(8) default '待审核',
reform_time date,
response_time date,
estimate_rate float,
estimate_detial varchar(60)
);

insert into maintenances(student_id,supervisor_id,repairer_id,repairer_type,fault_type,fault_location,fault_detail,fault_analysis,fault_state,reform_time,response_time,estimate_rate,estimate_detial)
values(1,1,5,"电工","电器损坏","教学楼E座教室151","一个灯泡损坏","正常损坏","修复","2017-05-07","2017-05-07",4.8,"很满意");

insert into maintenances(student_id,supervisor_id,repairer_id,repairer_type,fault_type,fault_location,fault_detail,fault_analysis,fault_state,reform_time,response_time,estimate_rate,estimate_detial)
values(1,1,5,"电工","电器损坏","公寓楼B座寝室413","卫生间灯泡损坏","正常损坏","修复","2017-04-07","2017-04-08",4.7,"较为满意");

insert into maintenances(student_id,supervisor_id,repairer_id,repairer_type,fault_type,fault_location,fault_detail,fault_analysis,fault_state,reform_time,response_time,estimate_rate,estimate_detial)
values(1,1,3,"水工","热水器问题","公寓楼B座寝室413","热水器的淋浴头出现裂缝","垃圾产品","修复","2017-05-07","2017-06-07",3.8,"维修效率低得可怕。绝对的差评！！！");

insert into maintenances(student_id,supervisor_id,repairer_id,repairer_type,fault_type,fault_location,fault_detail,fault_analysis,fault_state,reform_time,response_time,estimate_rate,estimate_detial)
values(2,2,2,"火工","暖气故障","教学楼E座教室151","暖气打开很久都感受不到暖和","暖气室的气压问题所致","修复","2017-02-27","2017-02-27",null,"");

insert into maintenances(student_id,supervisor_id,repairer_id,repairer_type,fault_type,fault_location,fault_detail,fault_analysis,fault_state,reform_time,response_time,estimate_rate,estimate_detial)
values(2,2,4,"水工","地漏问题","公寓楼A座寝室808","地漏堵塞不通水","长期积留的毛发堵住了下水口","修复","2017-03-27","2017-03-27",4.6,"问题很快得到了解决，给赞！");

insert into maintenances(student_id,supervisor_id,repairer_id,repairer_type,fault_type,fault_location,fault_detail,fault_analysis,fault_state,reform_time,response_time,estimate_rate,estimate_detial)
values(4,2,4,null,"其他故障","公寓楼B座寝室412","窗帘损坏","窗帘杆断折","修复","2017-04-07","2017-04-27",4.0,"失望");

DROP TABLE IF EXISTS checkcode;
create table checkcode(id int PRIMARY KEY AUTO_INCREMENT,
user_id bigint,
checkcode varchar(8) unique,
user_type varchar(8),
use_state char(1)
);

insert into checkcode(user_id,checkcode,user_type,use_state) values(2120101182,"1234","学生",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(2120101181,"8341","学生",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(3116370112,"2356","学生",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(101,"Q1W2","维修员",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(102,"A2D3","维修员",1);
insert into checkcode(user_id,checkcode,user_type,use_state) values(1001,"5698","宿舍管理员",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(3116370111,"HH6P","学生",1);
insert into checkcode(user_id,checkcode,user_type,use_state) values(104,"Q2Y4","维修员",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(1034,"SH6Q","超级管理员",0);
insert into checkcode(user_id,checkcode,user_type,use_state) values(1002,"9054","宿舍管理员",1);
insert into checkcode(checkcode,user_type,use_state) values("1S2T","学生",0);



DROP TABLE IF EXISTS itemList;
create table itemList(id int PRIMARY KEY AUTO_INCREMENT,
  maintenance_id int,
  item_id int,
  item_num int
);

insert into itemList(maintenance_id,item_id,item_num) values(1,4,1);
insert into itemList(maintenance_id,item_id,item_num) values(2,4,1);
insert into itemList(maintenance_id,item_id,item_num) values(3,2,1);
insert into itemList(maintenance_id,item_id,item_num) values(3,4,1);
insert into itemList(maintenance_id,item_id,item_num) values(5,10,1);
insert into itemList(maintenance_id,item_id,item_num) values(6,7,1);
insert into itemList(maintenance_id,item_id,item_num) values(6,9,1);






