package com.example.demo;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers") // db의 테이블명과 대소문자까지 다 틀리면 이렇게 table 어노테이션을 맞출 수 있음(매핑할 수 있음)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	// 엔티티 매핑 시 주의 사항
	// customer_number라는 이름의 멤버변수 없는데요?
	// ->
	
	@Id
	@Column(name = "customerNumber")
	private Integer customerNumber;
	
    @Column(name = "customerName", nullable = false, length = 50)
    private String customerName;

    @Column(name = "contactLastName", nullable = false, length = 50)
    private String contactLastName;

    @Column(name = "contactFirstName", nullable = false, length = 50)
    private String contactFirstName;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
	
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;
    
    @Column(name = "addressLine2", length = 50)
    private String addressLine2;
    
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "postalCode", length = 15)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 50)
    private String country;
    
    @Column(name = "salesRepEmployeeNumber")
    private Integer salesRepEmployeeNumber;
    
    // predcision : 숫자 타입에서 전체 자릿수 지정
    //  -> 최대 10자리 숫자 지정
    // scale : 소수점 이하 자리 수 지정
    //  -> 소수점 이하 2자리까지 저장 가능
    // BigDecimal : 자바에서 고정된 소수점 숫자를 표현하기 위한 참조 타입
    //  -> 주로 정확한 소수점 계산이나 금액을 계산하는 경우에 많이 사용
    //  -> 크레딧 한도 라던지 정확한 숫자 계산을 요구하는 금융 데이터를 처리하기 위해 사용될 가능성이 매우 높음
    @Column(name = "creditLimit", precision = 10, scale = 2)
    private BigDecimal creditLimit;
       
}
