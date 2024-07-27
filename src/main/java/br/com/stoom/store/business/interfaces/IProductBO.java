package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Product;

import java.util.List;

import java.util.List;

public interface IProductBO {
    List<Product> getAllProducts(boolean active);
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    void deactivateProduct(Long productId);
    void activateProduct(Long productId);
}
