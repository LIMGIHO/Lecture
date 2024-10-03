package hello.hello_spring.repository;

import hello.hello_spring.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJPAMemberRepository extends JpaRepository<Members, Long>, MemberRepository {

    @Override
    Optional<Members> findByName(String name);

}
