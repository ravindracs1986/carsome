CREATE TABLE carsome.Inspection (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slot_category` varchar(45) DEFAULT NULL,
  `slot_date` Date DEFAULT NULL,
  `slot_startTime` timestamp NULL DEFAULT NULL,
  `slot_endTime` timestamp NULL DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_phone` varchar(45) DEFAULT NULL,
  `crt_ts` timestamp NULL DEFAULT NULL,
  `update_ts` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;


CREATE TABLE subs_contacts (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subscribe_email` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `subject` VARCHAR(200) NULL,
  `message` TEXT NULL,
  `crt_ts` TIMESTAMP NULL,
  PRIMARY KEY (`id`));