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
            Parent parent = new Parent();

            Child child1 = new Child();
            Child child2 = new Child();

            parent.addchild(child1);
            parent.addchild(child2);
            em.persist(parent);
            parent.getChildes().remove(child1);

            em.flush();
            em.clear();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
