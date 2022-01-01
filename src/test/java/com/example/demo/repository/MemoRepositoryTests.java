package com.example.demo.repository;

import com.example.demo.entity.Memo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
            System.out.println(memoRepository.getClass().getName());
    }


    @Test
    @DisplayName("100개의 memo객체 저장 테스트")
    public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    @DisplayName("100번째 memo객체 조회 테스트")
    public void testSelect(){
        Long id = 100L;
        Optional<Memo> result = memoRepository.findById(id);
        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    @Transactional
    @DisplayName("새로운 100번째 객체 만들고 수정 테스트")
    public void testUpdate(){
        Memo memo = Memo.builder().id(100L).memoText("수정된 메모").build();
        memoRepository.save(memo);
    }


    @Test
    @DisplayName("100번째 객체 삭제 테스트")
    public void testDelete(){
        Memo memo = Memo.builder().id(100L).build();
        memoRepository.delete(memo);
    }


}
