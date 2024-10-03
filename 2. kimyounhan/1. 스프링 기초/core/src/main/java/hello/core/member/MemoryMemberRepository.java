package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member meber) {
        store.put(meber.getId(), meber);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

}
