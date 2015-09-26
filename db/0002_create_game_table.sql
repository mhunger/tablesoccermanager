CREATE TABLE `team` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `player1` int(11) unsigned NOT NULL,
  `player2` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `player1` (`player1`),
  KEY `player2` (`player2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
