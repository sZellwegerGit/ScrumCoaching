package main;

import javax.persistence.*;

@Entity
@Table(name = "userRating")
public class UserRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(name = "reliability", nullable = false, columnDefinition = "int default 3")
    private int reliability;

    @Column(name = "efficiency", nullable = false, columnDefinition = "int default 3")
    private int efficiency;

    @Column(name = "teamplayer", nullable = false, columnDefinition = "int default 3")
    private int teamplayer;

    public UserRating() {
    }

    public UserRating(int userId, int reliability, int efficiency, int teamplayer) {
        this.userId = userId;
        this.reliability = reliability;
        this.efficiency = efficiency;
        this.teamplayer = teamplayer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public int getTeamplayer() {
        return teamplayer;
    }

    public void setTeamplayer(int teamplayer) {
        this.teamplayer = teamplayer;
    }

    @Override
    public String toString() {
        return "UserRating{" +
                "id=" + id +
                ", userId=" + userId +
                ", reliability=" + reliability +
                ", efficiency=" + efficiency +
                ", teamplayer=" + teamplayer +
                '}';
    }
}

