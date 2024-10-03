package hello.hello_spring.repository;

import hello.hello_spring.domain.Members;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Members save(Members member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Members> findById(long id) {
        Members member = em.find(Members.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Members> findByName(String name) {
        return em.createQuery("select m from Members m where m.name = :name", Members.class)
                .setParameter("name", name)
                .getResultList().stream().findFirst();
    }

    @Override
    public List<Members> findAll() {
        return em.createQuery("select m from Members m", Members.class)
                .getResultList();
    }
}
