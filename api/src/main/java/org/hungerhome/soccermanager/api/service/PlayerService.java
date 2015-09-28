package org.hungerhome.soccermanager.api.service;

import org.hungerhome.soccermanager.api.entity.Player;
import org.hungerhome.soccermanager.api.entity.Team;
import org.hungerhome.soccermanager.api.error.TeamsCouldNotBeCreatedException;
import org.hungerhome.soccermanager.api.repository.PlayerRepository;
import org.hungerhome.soccermanager.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "PlayerService")
public class PlayerService
{
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    /**
     * create the teams for the given player. It will get all other players and create one team for each with
     * with the given player
     *
     * @param inputPlayer
     * @return void
     * @throws Exception
     */
    public void createTeamsForPlayer(Player inputPlayer) throws TeamsCouldNotBeCreatedException
    {
        Iterable<Player> players = playerRepository.findAll();
        ArrayList<Team> teams = new ArrayList<Team>();

        for (Player player : players) {
            if (!player.getId().equals(inputPlayer.getId())) {
                Team team = new Team();
                team.setPlayer1(inputPlayer);
                team.setPlayer2(player);

                teams.add(team);
            }
        }

        try
        {
            teamRepository.save(teams);
        } catch(Exception e) {
            throw new TeamsCouldNotBeCreatedException(
                "Teams for player: ["
                + inputPlayer.getName() + "] could not be created"
            );
        }
    }
}
