package org.hungerhome.soccermanager.api.framework;

import org.hungerhome.soccermanager.api.entity.Player;
import org.hungerhome.soccermanager.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Player.class)
public class PlayerEventHandler
{
    @Autowired
    private PlayerService playerService;

    @HandleAfterCreate
    public void handlePlayerSave(Player player)
    {
        playerService.createTeamsForPlayer(player);
    }
}
