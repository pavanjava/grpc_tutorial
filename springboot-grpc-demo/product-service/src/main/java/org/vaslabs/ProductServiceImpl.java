package org.vaslabs;

import com.vaslabs.proto.Category;
import com.vaslabs.proto.Product;
import com.vaslabs.proto.ProductList;
import com.vaslabs.proto.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
    @Override
    public void getProductById(Product request, StreamObserver<Product> responseObserver) {
        InMemoryData.getProducts()
                .stream()
                .filter(product -> product.getProductId() == request.getProductId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getProductByCategoryId(Category request, StreamObserver<ProductList> responseObserver) {
        List<Product> products = InMemoryData.getProducts()
                .stream()
                .filter(product -> product.getCategoryId() == request.getCategoryId())
                .toList();

        ProductList productList = ProductList.newBuilder().addAllProduct(products).build();

        responseObserver.onNext(productList);
        responseObserver.onCompleted();
    }
}
