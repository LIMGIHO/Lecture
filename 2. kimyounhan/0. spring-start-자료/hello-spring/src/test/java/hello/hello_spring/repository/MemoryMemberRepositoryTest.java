package hello.hello_spring.repository;

import hello.hello_spring.domain.Members;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    private Members member1;

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Members member = new Members();
        member.setName("test");

        repository.save(member);
        Members result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(result, member);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Members member1 = new Members();
        member1.setName("spring1");
        repository.save(member1);

        Members member2 = new Members();
        member2.setName("spring2");
        repository.save(member2);

        Members result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Members member1 = new Members();
    }
}
