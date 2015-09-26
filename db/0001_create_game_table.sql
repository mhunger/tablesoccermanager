CREATE TABLE `game` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `opponent1` int(11) unsigned NOT NULL,
  `opponent2` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `opponent1` (`opponent1`),
  KEY `opponent2` (`opponent2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
