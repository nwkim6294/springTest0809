package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    @Column(name = "requiredDate", nullable = false)
    private LocalDate requiredDate;

    @Column(name = "shippedDate")
    private LocalDate shippedDate;

    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @Lob
    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;
    
    // CascadeType.ALL : 모든 작업이 부모 엔티티에서 자식 엔티티로 전파되도록 설정
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    
}
