package org.hungerhome.soccermanager.api.repository;

import org.hungerhome.soccermanager.api.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> { }
