package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repo.CustomerRepository;
import com.example.demo.Repo.ProductRepository;
import com.example.demo.comment.Comment;
import com.example.demo.comment.CommentRepository;

@SpringBootTest
class TestApplicationTests {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void contextLoads() {
		// Post 클래스를 기반으로 객체를 만들고 활용해보기.
//		List<Customer> lists=this.customerRepository.findAll();
//		System.out.println(lists.toString());
		
//		List<Customer> lists = customerRepository.findAllNative();
//		lists.forEach(System.out::println);
		
		BigDecimal jonnakum = new BigDecimal("100.00");
		
		List<Product> result = productRepository.findProduct1(jonnakum);
		
		//System.out.println(result);
		assertThat(result).isNotNull();
		assertThat(result).isNotEmpty();

		
		
		
	}
	
	

}