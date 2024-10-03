package hello.hello_spring.repository;

import hello.hello_spring.domain.Members;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Members save(Members member);
    Optional<Members> findById(long id);
    Optional<Members> findByName(String name);
    List<Members> findAll();
}
