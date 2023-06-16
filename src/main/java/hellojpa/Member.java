package hellojpa;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String name;


    @OneToMany
    @JoinColumn(name="team_id")
    private Team team;

}