
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `sub_name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`));

INSERT INTO `role` VALUES (1,'ROLE_USER','User'),(2,'ROLE_ADMIN','Admin'),(3,'ROLE_MANAGER','Manager'),(4,'ROLE_OWNER','Owner');
```




