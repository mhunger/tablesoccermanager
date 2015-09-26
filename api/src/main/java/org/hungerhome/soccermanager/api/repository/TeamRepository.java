package org.hungerhome.soccermanager.api.repository;

import org.hungerhome.soccermanager.api.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>
{
}
