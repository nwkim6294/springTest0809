package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;
    
    // 지연 로딩: 실제로 엔티티와 연관된 데이터를 필요로 할때 DB에서 가져오도록 접근하는 방식
    //  -> 연관된 엔티티를 처음에는 로드하지 않고 해당 엔티티에 접근할때만 DB에서 데이터를 조회해오는 방식
    //  -> office 객체를 사용할때만 select 쿼리가 나가도록 처리
    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY : 지연로딩
    // JoinColumn 또한 생략 가능하지만 권장하지는 않음
    // 필드명 + "_" + 참조하는 테이블의 PK 컬럼명 <--- 스네이크 표기법으로
    // 컬럼을 찾으려함(이러다보면 예상치 못한 컬럼명이 생성될 수 있음)
    @JoinColumn(name = "officeCode")
    private Office office;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee manager;
}
