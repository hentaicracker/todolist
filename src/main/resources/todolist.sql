-- 用户表
DROP TABLE IF EXISTS user;
CREATE TABLE user (
	id int(11) NOT NULL AUTO_INCREMENT,
	user_name varchar(255),
	user_psd varchar(255),
	user_type varchar(255),
	nick_name varchar(255),
	user_avatar varchar(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 任务表
DROP TABLE IF EXISTS task;
CREATE TABLE task (
	id int(11) NOT NULL AUTO_INCREMENT,
	user_id int(11) NOT NULL,
	task_name varchar(255),
	task_content longtext,
	start_time datetime DEFAULT null,
	end_time datetime DEFAULT null,
	task_priority int(10),
	task_longitude int(10),
	task_latitude int(10),
	task_done int(10) DEFAULT 0,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



