package hello.hello_spring.repository;

import hello.hello_spring.domain.Members;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Members> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Members save(Members member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Members> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Members> findByName(String name) {
        return store.values().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Members> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

