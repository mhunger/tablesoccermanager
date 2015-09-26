CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `team1_id` bigint(20) DEFAULT NULL,
  `team2_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_15r4kov5p6f4ijd9hapsre134` (`team1_id`),
  KEY `FK_3s8ikw4aasdhnp0vwvm6ra6k1` (`team2_id`),
  CONSTRAINT `FK_3s8ikw4aasdhnp0vwvm6ra6k1` FOREIGN KEY (`team2_id`) REFERENCES `player` (`id`),
  CONSTRAINT `FK_15r4kov5p6f4ijd9hapsre134` FOREIGN KEY (`team1_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
