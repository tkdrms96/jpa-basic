package hellojpa;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity{
    @Id
    @Column(name="USER_ID")
    @GeneratedValue
    private Long id;

    @Column(name="USERNAME")
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
