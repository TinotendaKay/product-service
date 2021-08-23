package com.tinotenda.productservice.controllers;

import com.tinotenda.productservice.dto.Coupon;
import com.tinotenda.productservice.model.Product;
import com.tinotenda.productservice.repos.ProductRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ProductControllerTest {

    public static final String COUPON_CODE = "SUPERSALE";
    public static final String COUPON_SERVICE_URL = "http://localhost:8080/couponapi/coupons/";
    @Mock
    private ProductRepo repo;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductController productController;


    @Test
    void create() {
       /* Coupon coupon = new Coupon();
        coupon.setCode(COUPON_CODE);
        coupon.setDiscount(new BigDecimal(10));

        when(restTemplate.getForObject(COUPON_SERVICE_URL + COUPON_CODE, Coupon.class)).thenReturn(coupon);

        Product product = new Product();
        product.setCouponCode(COUPON_CODE);
        product.setPrice(new BigDecimal(100));
        when(repo.save(product)).thenReturn(product);

        ResponseEntity<Product> result = productController.create(product);
        Product body = result.getBody();
        verify(restTemplate).getForObject(COUPON_SERVICE_URL+COUPON_CODE, Coupon.class);
        verify(repo).save(product);

        assertNotNull(body);
        assertEquals(COUPON_CODE, body.getCouponCode());*/
    }

    @Test
    void getProduct() {
    }
}