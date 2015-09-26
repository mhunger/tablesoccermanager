package org.hungerhome.soccermanager.api.repository;

import org.hungerhome.soccermanager.api.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> { }
