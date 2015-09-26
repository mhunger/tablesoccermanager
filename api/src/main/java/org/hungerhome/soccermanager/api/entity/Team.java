package org.hungerhome.soccermanager.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "team")
public class Team
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @OneToOne(targetEntity = Player.class)
    @JoinColumn(name = "player1_id")
    private Player player1;

    @JoinColumn(name = "player2_id")
    @OneToOne(targetEntity = Player.class)
    private Player player2;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Player getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(Player player1)
    {
        this.player1 = player1;
    }

    public Player getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(Player player2)
    {
        this.player2 = player2;
    }
}
