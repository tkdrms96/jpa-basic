package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member(5L, "member");
            member.setName("zzzz");
            em.persist(member);
            System.out.println("before flush");
            em.flush();
            System.out.println("after flush");
            tx.commit();
        }catch (Exception e ){

        }

    }
}
