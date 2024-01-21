package org.vaslabs.service.helpers;

import com.vaslabs.proto.ProductList;
import org.vaslabs.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class DtoMappingHelper {

    public static List<org.vaslabs.dto.Product> mapProductListToProductDTO(ProductList productList) {
        List<Product> products = new ArrayList<>();
        productList.getProductList().forEach(product -> {
            Product product1 = getProduct();
            product1.setId(product.getProductId());
            product1.setCategoryId(product.getCategoryId());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());

            products.add(product1);
        });
        return products;
    }

    public static org.vaslabs.dto.Product mapProductToProductDTO(com.vaslabs.proto.Product product) {
        Product product1 = getProduct();
        product1.setId(product.getProductId());
        product1.setCategoryId(product.getCategoryId());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        return product1;
    }

    private static Product getProduct(){
        return new Product();
    }
}
