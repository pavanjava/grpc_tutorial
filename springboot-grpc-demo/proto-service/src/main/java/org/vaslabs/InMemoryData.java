package org.vaslabs;

import com.vaslabs.proto.Product;

import java.util.Arrays;
import java.util.List;

public class InMemoryData {
    public static List<Product> getProducts() {
        return Arrays.asList(
                Product.newBuilder().setProductId(1).setName("MacBook Pro M2").setDescription("Laptop with excellent performance").setPrice(245000.0f).setCategoryId(1).build(),
                Product.newBuilder().setProductId(2).setName("MacBook Air M3").setDescription("Laptop with excellent performance").setPrice(223000.0f).setCategoryId(1).build(),
                Product.newBuilder().setProductId(3).setName("iPhone 15 pro").setDescription("Phone with excellent performance").setPrice(134000.0f).setCategoryId(2).build(),
                Product.newBuilder().setProductId(4).setName("iPhone 15 Plus").setDescription("Phone with excellent performance").setPrice(125000.0f).setCategoryId(2).build(),
                Product.newBuilder().setProductId(5).setName("iWatch 2").setDescription("Smart Watch with excellent performance").setPrice(78000.0f).setCategoryId(3).build(),
                Product.newBuilder().setProductId(6).setName("Earpods 2").setDescription("in the ear, excellent sound").setPrice(45000.0f).setCategoryId(3).build(),
                Product.newBuilder().setProductId(7).setName("Earpods 1").setDescription("in the ear, excellent sound").setPrice(32000.0f).setCategoryId(3).build()
        );
    }
}