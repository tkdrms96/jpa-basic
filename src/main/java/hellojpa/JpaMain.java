package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx= em.getTransaction();

        tx.begin();

        /* 예외처리 */
        try {
            //@OneToMany -- default EAGER

            //@ManyToOne LAZY -- default LAZY
            Member member = new Member();
            member.setUserName("zxzxzx");
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, 1L);

            Team team = findMember.getTeam();
            System.out.println(team.getName());
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
