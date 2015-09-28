package org.hungerhome.soccermanager.api.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Primary;
import sun.jvm.hotspot.memory.Generation;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "game")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Game
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Timestamp date;

    @JoinColumn(name = "team1_id")
    @OneToOne(targetEntity = Team.class)
    private Team team1;

    @JoinColumn(name = "team2_id")
    @OneToOne(targetEntity = Team.class)
    private Team team2;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Timestamp getDate()
    {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }

    public Team getTeam1()
    {
        return team1;
    }

    public void setTeam1(Team team1)
    {
        this.team1 = team1;
    }

    public Team getTeam2()
    {
        return team2;
    }

    public void setTeam2(Team team2)
    {
        this.team2 = team2;
    }
}
