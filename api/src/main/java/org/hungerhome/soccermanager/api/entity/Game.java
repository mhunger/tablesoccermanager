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
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "opponent1")
    @OneToOne(targetEntity = Player.class)
    private Player opponent1;

    @Column(name = "opponent2")
    @OneToOne(targetEntity = Player.class)
    private Player opponent2;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public Player getOpponent1()
    {
        return opponent1;
    }

    public void setOpponent1(Player opponent1)
    {
        this.opponent1 = opponent1;
    }

    public Player getOpponent2()
    {
        return opponent2;
    }

    public void setOpponent2(Player opponent2)
    {
        this.opponent2 = opponent2;
    }
}
