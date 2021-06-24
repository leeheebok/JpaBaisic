package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //조회 !@Member findMember = em.find(Member.class, 1L);
            //!삭제 em.remove(findMember)
            //@수정 findMember.setName("HelloJPA")
            //전체결과 조회List<Member> result = em.createQuery("select m from Member as m", Member.class).setFirstResults(1).setMaxResults(10).getResultList();

            //비영속
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");

            //영속
//            em.persist(member);
//
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
