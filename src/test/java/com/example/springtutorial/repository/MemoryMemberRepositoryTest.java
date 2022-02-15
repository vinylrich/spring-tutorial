import com.example.springtutorial.domain.Member;
import com.example.springtutorial.repository.MemoryMemberRepository;
import com.example.springtutorial.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository;
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @BeforeEach
        @Test
        public void save() {
            Member member = new Member();
            member.setName("spring");
            repository.save(member);

            Member result = repository.findById(member.getId()).get();//optional에서 값을 꺼낼 때

            assertThat(result).isEqualTo(member);

        }
        @Test
        public void findByName(){
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);
            Member result = repository.findByName("spring1").get();

            assertThat(result).isEqualTo(member1);
        }

        @Test
        public void findAll(){
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            List<Member> resultList = repository.findAll();

            assertThat(resultList.size()).isEqualTo(2);

        }
}
