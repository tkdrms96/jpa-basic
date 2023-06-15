package hellojpa;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    @Column(name = "TEAM_ID")
    private Long teamId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getTeamId() {
        return teamId;
    }
}