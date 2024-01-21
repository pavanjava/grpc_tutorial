package org.vaslabs;

import com.vaslabs.proto.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = InMemoryData.getProducts()
                .stream()
                .filter(product -> product.getCategoryId() == 2)
                .toList();
        System.out.println(products);
    }
}
