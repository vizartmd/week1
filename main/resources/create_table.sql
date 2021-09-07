CREATE DATABASE testdb ENCODING 'UTF-8';

CREATE TABLE IF NOT EXISTS myusers (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `first_name`varchar(100) NOT NULL,
   `last_name`varchar(100) NOT NULL,
   `user_name`varchar(100) NOT NULL,
   INDEX `first_name_ind` (`first_name`),
   INDEX `last_name_ind` (`last_name`),
   INDEX `user_name_ind` (`user_name`),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO myusers (first_name, last_name, user_name) VALUES ('Max', 'Bulaev', 'maxim');
INSERT INTO myusers (first_name, last_name, user_name) VALUES ('Leonid', 'Besleaga', 'lyoha');
INSERT INTO myusers (first_name, last_name, user_name) VALUES ('Anastasia', 'Pruneanu', 'nastin');

CREATE TABLE IF NOT EXISTS mytasks (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `title` varchar(100) NOT NULL,
   `description` varchar(250) NOT NULL,
   INDEX `title_ind` (`title`),
   INDEX `desc_ind` (`description`),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO mytasks (title, description) VALUES ('title 1', 'description 1');
INSERT INTO mytasks (title, description) VALUES ('title 2', 'description 2');
INSERT INTO mytasks (title, description) VALUES ('title 3', 'description 3');

CREATE TABLE IF NOT EXISTS users_tasks (
   `user_id` int unsigned NOT NULL,
   `task_id` int unsigned NOT NULL,
   PRIMARY KEY (`user_id`,`task_id`),
   CONSTRAINT fk_user_id FOREIGN KEY (`user_id`) REFERENCES myusers (`id`),
   CONSTRAINT fk_task_id FOREIGN KEY (`task_id`) REFERENCES mytasks (`id`)
) ENGINE=InnoDB;

INSERT INTO users_tasks (user_id, task_id) VALUES (1, 1);
INSERT INTO users_tasks (user_id, task_id) VALUES (1, 2);
INSERT INTO users_tasks (user_id, task_id) VALUES (2, 1);
INSERT INTO users_tasks (user_id, task_id) VALUES (3, 1);
INSERT INTO users_tasks (user_id, task_id) VALUES (3, 4);
INSERT INTO users_tasks (user_id, task_id) VALUES (2, 4);