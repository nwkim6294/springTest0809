package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class WordWareHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스프링 용어정리집.
		// JPA(Java Persistence API)
		// ORM(Object Relational Mapping)
		//   -> 프로그래밍 문법으로도 데이터 베이스를 다룰수 있는 방법.
		//   -> ORM을 이용하면 개발자는 SQL을 직접 쓰지 않아도 DB를 활용하는것이 가능
		//      (이론상으로는요)
		//   -> JPA는 자바의 ORM 프레임워크를 JPA라 부름.
		//   -> JPA를 실제로 구현한 클래스들중 대표적인것이 하이버네이트 라는 클래스가 있음.
		
		// @Autowired : 해당 필드나 생성자 또는 메서드에 대해 스프링 컨테이너가
		//              적절한 객체(Bean)를 찾아 자동으로 주입해주는 어노테이션
		//    -> 안쓰면 생성자부터 일일히 직접 선언하고 연결하는게 너무 구찮음.
		
		// JUnit : 테스트코드를 작성하고 작성한 테스트 코드를 실행할때 사용하는 자바의 프레임워크
		//  -> 스프링과는 별개의 프레임워크.
		
		
		// 엔티티 관련 용어 정리.
		// @Entity : 스프링이 해당 클래스를 엔티티 객체로 인식하도록 돕는 어노테이션
		// @Id : 기본키 설정
		//   - 고유한 값인 컬럼(맴버변수)를 설정해야해서
		//   - 중복이 없는 컬럼으로 설정해야함.
		// @GeneratedValue : 데이터 저장시 해당 속성에 값을 지정하지 않아도
		//                   자동으로 1씩 증가하여 저장되는 어노테이션.
		// strategy = GenerationType.IDENTITY : 고유한 번호를 생성하는 방법을 지정하는 부분.
		//  IDENTITY : db가 기본 키값을 자동으로 생성하도록 유도.
		//  GenerationType : 전략설정.
		
		// @Column : 컬럼(맴버변수)에 다양한 제약조건을 설정할수 있음)
		//  -> 열(컬럼)의 세부 설정을 진행
		// length : 열의 길이 설정
		// columnDefinition : 열 데이터의 유형이나 성격을 정의할때
		//  - TEXT : 말그대로 문자(텍스트)들을 열의 데이터로 넣을수 있음.
		//  - 잘모르겠다 싶으면 내가 알고있는 DB sql문법으로 작성해도 됨.
		// name : dbms 컬럼명(흔히 dbms에 써둔 컬럼명과 일치시킬때 사용) 
		// nullable : null값 허용 여부. (기본값 : true)
		// unique
		// precision : 전체 자릿수 설정
		// scale : 소숫점 이하 자릿수
		//  -> precision, scale 사용예시 : @Column(precision = 10, scale = 2)
		//  -> decimal(10, 2);
		
		
		// 엔티티(테이블) 연관관계 매핑 어노테이션
		// @ManyToOne = N:1
		// @OneToMany = 1:N
		// @ManyToMany = N:M
		
		// 유효성검사(validation check) : 데이터를 검증하는 단계
		// @NotNull(message ="메세지") : 널값 불허
		// @NotBlank(message="메세지") : 공백 불허
		// @Size(min =2, max = 50, message ="메세지") : 최소 최대 크기 부여 가능
		// @Email() : 이메일 형식 검증
		
		// 숫자관련
		// @Min(value = 20, message = "20이하면 이 메세지뜸")
		// @Max(min과 사용방법 같음)
		// @Pattern(정규표현식을 활용하여 많은 조건을 지정할수 있음.)
		
		// 날짜 관련
//	    @CreatedDate
//	    private LocalDateTime createdAt;
//	    // 토심이: "생성 시간은 제가 자동으로 기록해드릴게요!"
//	    
//	    @LastModifiedDate  
//	    private LocalDateTime updatedAt;
//	    // 토심이: "수정 시간도 실시간으로 업데이트해드려요!"
//	    
//	    @CreatedBy
//	    private String createdBy;
//	    // 토심이: "누가 만들었는지도 기록할 수 있어요!"
//	    
//	    @LastModifiedBy
//	    private String lastModifiedBy;
//	    // 토심이: "마지막 수정자도 추적 가능합니다!"
		
		// 쿠키와 세션
		// 쿠키 : 클라이언트 로컬에 저장되는 키와 값이 들어있는 작은 데이터파일.
		//  - 사용자 인증이 유효한 시간 자체를 명시할수 있어서.
		//  - 유효 시간이 정해지면 브라우저가 종료되어도 인증이 유지된다는 특징이 있음.
		//  - 클라이언트의 상태정보를 로컬에 저장했다가 참조.
		
		// 세션 : 쿠키랑 비슷한데 다만 저장위치가 해당 서비스를 제공하는 서버측. 
		//       세션ID라는것을 부여한후 서버에 접속해서 종료할때까지
		//       인증상태를 유지하는것이 일반적.
		
		// 유효성 검사 관련 어노테이션
		// @NotEmty(message="이 칸은 비워두면 안돼!") : 이 칸은 비워두면 안돼!
		//  - 대상 타입 : String, Collection, Map, Array
		//    null 값이거나 내용물이 하나도 없는 경우를 불허.
		//  - 주의사항 : 단 공백문자만 있는 경우는 통과 가능
		//    예를들면 게시글 내용처럼 내용은 반드시 필요하되 공백은 허용해야할때 사용
		// @NotBlank(message="") : 공백은 인정 못해!
		//  - 기본적으로 NotEmty 포함
		//  - String에만 가능
		//    사용자 아이디, 닉네임, 게시글 제목(좀 애매) 같이 의미없는 공백을 허용하고싶지 않을때
		// @NotNull(message="") : 오직 null 객체가 들어있는지만 확인, 공백이나 빈 List는 허용
		//  - 나이, 가격, 동의 여부 처럼 0이나 false도 의미있는 값이라서 null 자체만 막고 싶을때
		// @Size(min = 9, max = 20, message="") : 최소 글자 수 최대 글자 수를 지정할때 사용 
		//  - String, Collection 등을 활용할 수 있음
		//    문자열의 길이나 컬렉션의 크기가 지정된 최소 최대값 범위 안인지 확인
		// @Min, Max : 숫자들의 크기를 제한할때
		// @Min(value =1, message ="주문 수량은 1개 이상 이어야 합니다.")
		//  - int long Integer
		// @Email(사용자 비추)
		//  - 이메일 체크, @ 있냐 없냐 기준으로 체크
		//  1. @ 만 있으면 별의별 이메일 형식을 다 통과 시킬 수 있음
		//	   ex) powerNureong@nureong@i.com -> 올바른 사이트 이메일 아닌데도 통과됨
		//     -> 그러니 이 어노테이션을 쓸때는 2차 인증을 무조건 걸어두는 것이 사용자나 개발자나 서로가 서로에게 머리 아픈일이 없음
		// @Patter()

		
		// bindingResult : 검증을 진행하면 검증의 결과를 담아낼 객체.
		//  -> 검증 대상 바로 뒤에 위치 시키면됨.
				
		
		//@ControllerAdvice 
		// - 모든 컨트롤러를 중앙집중식으로 관리하는 어노테이션.
		//   (모든 컨트롤러에 적용되는것이 기본. 단 특정한 범위로 제한하는것도 가능.
		//    제한범위 : 해당 컨트롤러 파일, 해당 패키지, 상속관계
		// - 컨트롤러에서 공통적으로 발생하는 예외나 로직을 중앙에서 처리할수 있게 해주는 기능.
		// - AOP 하기전에 연습한다 생각하세요
		
		// 페이징 처리를 돕는 클래스(객체)
		// Page : 페이징 그 자체를 위한 클래스
		// Pageable : 페이징 처리를 실질적으로 진행하는 클래스
		// PageRequest : 현재 페이지와 한 페이지에 보여줄 게시물 개수등을 설정하여
		//               페이징 요청을 진행하는 클래스
		
		// 페이징 관련 템플릿단(타임리프 기준)의 주요 코드
		// th:classappend="${!paging.hasPrevious} ? 'disable'"
		//  -> 이전 페이지가 없으면 '이전' 링크를 비활성화
		//     (해당하는 객체가 없으면 해당 링크 비활성화)
		// th:classappend="${!paging.hasNext} ? 'disabled'"
		//  -> 다음 페이지가 없으면 '다음' 링크를 비활성화
		
		// th:href="@{|?page=${paging.number-1}|}" : 이전 페이지 링크
		// th:href="@{|?page=${paging.number+1}|}" : 다음 페이지 링크
		
		// 0부터 전체 페이지 수 만큼 이 요소를 반복하여 생성
		// 현재 순번은 page 객체(변수)에 대입
		// th:each="page: ${#numbers.sequence(0, paging.totalPages-1)}"
		
		// th:classappend="${page == paging.number} ? 'active'"
		// 반복 구간내에서 해당 페이지가 현재 페이지와 같은 경우 active 클래스를 적용한다
		
		// 프로젝트 생성 후 만들어진 디렉토리 구조 설명
		// src/main/java : 자바 파일 저장 공간.
		//  -> 컨트롤러, 서비스, DTO, 엔티티, Repo 등 서버단에서 동작하는 코드들을 저장
		//     (프로젝트명 Application 파일 통해 IoC가 발생하면서 프로젝트가 구동)
		// src/main/resource : 템플릿 저장공간
		//  -> static : 정적파일 저장공간
		//     ex) css, js, 이미지 등 미디어 파일
		//  -> application.properties : 프로젝트 환경설정 파일
		//				  .yml
		//     (스트링부트는 그래도 사용자 편의가 제법 괜찮은 프레임워크)
		// src/test/java : junit으로 스프링 부터의 테스트 도구를 사용하여
		//                 서버 실행없이 java 디렉토리에 작성한 코드를 테스트할 수 있음
		
		// @RestController : 스프링에서 RESTful 웹 서비스를 구축할때 사용
		//  - @Controller는 리턴 시 템플릿을 쫓아간다 치면
		//  - @RestController는 리턴시 값 자체를 뱉어내는 개념이라 생각
		
		// RestController 특징
		// 객체를 리턴할때 자동으로 JSON 형식으로 변환하여 클라이언트에 전송
		// @Controller + @ResponseBody
		
		// 왜쓰나? : 간결하게 RESTful api 구현하려고
		//  -> GET, POST 말고도 
		
		// ResponseEntity
		// HTTP Response(응답)을 표현하는 클래스 
		//  -> 상태 코드, 헤더 및 본문을 모두 포함할 수 있음
		
		// 200, 404, 500 등의 상태코드 지정 가능
		// HTTP 응답을 세밀하게 제어하는 도구
		//  -> 개발자는 클라이언트에 대한 응답을 보다 명확하게 구성할 수 있음
	}

}
