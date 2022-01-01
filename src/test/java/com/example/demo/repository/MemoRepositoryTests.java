package com.example.demo.repository;

import com.example.demo.entity.Memo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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






}
