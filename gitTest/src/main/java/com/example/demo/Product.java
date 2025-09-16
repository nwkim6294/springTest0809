package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
public class Product {
	
    @Id
    @Column(name = "productCode", length = 15)
    private String productCode;

    @Column(name = "productName", nullable = false, length = 70)
    private String productName;

    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;

    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;

    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;
    
    // Lob(Large Object) : 
    // BLOB(Binary Large Object) : 이미지, 비디어, 파일과 같은 대용량 바이너리 데이터를 저장
    // CLOB(Character Large Object) : 텍스트 데이터와 같은 대용량 데이터를 저장
    // 리턴 타입에 따라 CLOB과 BLOB의 정의는 알아서
    //  -> String : CLOB, byte[] : BLOB
    @Lob
    @Column(name = "productDescription", nullable = false, columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "quantityInStock", nullable = false)
    private Integer quantityInStock;

    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;
    
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
