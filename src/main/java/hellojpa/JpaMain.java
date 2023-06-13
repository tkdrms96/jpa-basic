package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // ---- 1. 비영속과 영속상태 1차캐싱과 영속 조회에 대한 설명
            // 비영속
            /*Member member = new Member();
            member.setId(101L);
            member.setName("Hello Jpa");
            em.persist(member);

            // 영속 조회 순위 (1차캐시) -> DB
            Member findMember1 = em.find(Member.class, 101L);
            // 두번째 조회에서는 쿼리가 날라가지 않는다 (1차캐시에 담김)
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result : " + (findMember2 == findMember1)); //true 동일성보장*/

            // ---- 2. persist에서 쿼리가 안나가는이유
            // (jdbc batch) 버퍼 기능을 사용하여 모아서 쿼리를 날릴 수 있는 성능면에서 유리한 기능을 가지고 있음
            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "A");

            em.persist(member1);
            em.persist(member2);*/

            // ---- 3. 변경감지 (DirtyChecking)
            Member member = em.find(Member.class, 150L);
            member.setName("DirtyChecking");
            //데이터의 값만 변경 후 쿼리실행 시 update query가 나감

            // ---- 4. 플러시 = 영속성 컨테스트 == database
            em.persist(member);

            em.flush(); // DB에 반영

            // ---- 5. 준 영속 상태
            Member member2 = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //case 1 : 특정 한개의 영속성 컨텍스트에서 제외시킬때
            //em.detach(member2);
            //case 2 : 영속성 컨텍스트의 완전 초기화
            //em.clear();
            //case 3 : 영속성 컨텍스트를 종료
            //em.close();
            System.out.println("준영속 : " + member2);
            tx.commit(); // 트랜젝션 실행
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
