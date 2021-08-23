package com.tinotenda.productservice.controllers;

import com.tinotenda.productservice.dto.Coupon;
import com.tinotenda.productservice.model.Product;
import com.tinotenda.productservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    ProductRepo repo;

    @Autowired
    private RestTemplate restTemplate;
    @Value("${couponService.url}")
    private String couponServiceUrl;

    @PostMapping({"/product"})
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Coupon coupon = restTemplate.getForObject(couponServiceUrl + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return new ResponseEntity<>(repo.save(product), HttpStatus.OK);
    }

    @PostMapping({"/{id}"})
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(repo.findById(id).orElseThrow(() -> {
            return new Exception("Product with id: " + id + " could not be found");
        }), HttpStatus.OK);
    }

    public Product sendErrorResponse(Product product) {
        return product;
    }


}
