CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `player1_id` bigint(20) DEFAULT NULL,
  `player2_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_btxq96g4j422yjgdoianjkvr7` (`player1_id`),
  KEY `FK_rloir8pb96147vht4icb1jxn8` (`player2_id`),
  CONSTRAINT `FK_rloir8pb96147vht4icb1jxn8` FOREIGN KEY (`player2_id`) REFERENCES `player` (`id`),
  CONSTRAINT `FK_btxq96g4j422yjgdoianjkvr7` FOREIGN KEY (`player1_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
