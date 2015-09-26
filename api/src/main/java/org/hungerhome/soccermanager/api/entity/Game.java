package org.hungerhome.soccermanager.api.entity;


import org.springframework.context.annotation.Primary;
import sun.jvm.hotspot.memory.Generation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @JoinColumn(name = "team1_id")
    @OneToOne(targetEntity = Player.class)
    private Player team1;

    @JoinColumn(name = "team2_id")
    @OneToOne(targetEntity = Player.class)
    private Player team2;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Player getTeam1()
    {
        return team1;
    }

    public void setTeam1(Player team1)
    {
        this.team1 = team1;
    }

    public Player getTeam2()
    {
        return team2;
    }

    public void setTeam2(Player team2)
    {
        this.team2 = team2;
    }
}
