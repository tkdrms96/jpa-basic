package hellojpa;

import javax.persistence.*;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx= em.getTransaction();

        tx.begin();

        /* 예외처리 */
        try {
            //movie 등록
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setName("바람과 함께 사라지다.");
            movie.setPrice(10000);

            em.persist(movie);
            em.clear();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
