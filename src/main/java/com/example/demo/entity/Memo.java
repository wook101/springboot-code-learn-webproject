package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tb1_memo")
@ToString
@Getter //Getter를 이용하여 Getter메서드를 생성하고
@Builder //Builder를 이용해서 객체를 생성할 수 있게 처리, @Builder를 사용하기 위해서는 @AllArgsConstructor, @NoArgsConstructor를 같이 처리해아 된다.
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //null을 사용할 수 있기 때문에 Wrapper타입인 Long을 사용

    @Column(length = 200, nullable = false)
    private String memoText;

}
