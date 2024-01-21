package org.vaslabs.service;

import com.vaslabs.proto.Category;
import com.vaslabs.proto.Product;
import com.vaslabs.proto.ProductList;
import com.vaslabs.proto.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.vaslabs.service.helpers.DtoMappingHelper.mapProductListToProductDTO;
import static org.vaslabs.service.helpers.DtoMappingHelper.mapProductToProductDTO;

@Service
public class ProductServiceRPC {

    @GrpcClient("grpc-product-service")
    ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    public org.vaslabs.dto.Product getProductById(int id) {
        Product product = Product.newBuilder().setProductId(id).build();
        Product response = productServiceBlockingStub.getProductById(product);
        return mapProductToProductDTO(response);
    }

    public List<org.vaslabs.dto.Product> getProductByCategoryId(int id) {
        Category category = Category.newBuilder().setCategoryId(id).build();
        ProductList response = productServiceBlockingStub.getProductByCategoryId(category);
        return mapProductListToProductDTO(response);
    }
}
