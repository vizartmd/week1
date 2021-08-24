CREATE TABLE myusers (
 `id` int unsigned NOT NULL AUTO_INCREMENT,
   `first_name`varchar(100) DEFAULT NULL,
   `last_name`varchar(100) DEFAULT NULL,
   INDEX `first_name_ind` (`first_name`),
   INDEX `last_name` (`last_name`),
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB;

CREATE TABLE mytasks (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `tytle` varchar(100) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  INDEX `user_ind` (`user_id`),
  INDEX `tytle_ind` (`tytle`),
  INDEX `desc_ind` (`description`),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`)
  REFERENCES myusers(`id`)
  ON DELETE CASCADE
) ENGINE=InnoDB;